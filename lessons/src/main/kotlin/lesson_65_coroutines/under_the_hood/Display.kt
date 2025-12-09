package lesson_65_coroutines.under_the_hood

import lesson_65_coroutines.entities.Author
import lesson_65_coroutines.entities.Book
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import kotlin.concurrent.thread

object Display {

    private val infoArea = JTextArea().apply {
        isEditable = false
        font = Font(Font.SANS_SERIF, Font.BOLD, 18)
    }
    private val loadButton = JButton("Загрузить книгу").apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 15)
        addActionListener {
            loadData()
        }
    }
    private val timerLabel = JLabel("Время: 00:00").apply {
        font = Font(Font.SANS_SERIF, Font.BOLD, 15)
    }
    private val topPanel = JPanel(BorderLayout()).apply {
        add(timerLabel, BorderLayout.WEST)
        add(loadButton, BorderLayout.EAST)
    }


    private val mainFrame = JFrame("Книги и авторы").apply {
        layout = BorderLayout()
        add(topPanel, BorderLayout.NORTH)
        add(JScrollPane(infoArea), BorderLayout.CENTER)
        size = Dimension(600, 600)
    }

    fun show() {
        mainFrame.isVisible = true
        startTimer()
    }

    private fun loadData(step: Int = 0, data: Any? = null) {

        when (step) {
            0 -> {
                loadButton.isEnabled = false
                infoArea.text = "Идет загрузка информации о книге...\n"
                loadBook { loadData(1, it) }
            }

            1 -> {
                val book = data as Book
                infoArea.append("Книга: ${book.title}\nГод: ${book.year}\nЖанр: ${book.genre}\n")
                infoArea.append("Идет загрузка информации о авторе...\n")
                loadAuthor(book) { loadData(2, it) }
            }

            2 -> {
                val author = data as Author
                infoArea.append("Автор: ${author.name}\nБиография: ${author.bio}\n")
                loadButton.isEnabled = true
            }
        }
    }

    private fun loadBook(callback: (Book) -> Unit) {
        thread {
            Thread.sleep(3000)
            callback(Book("Властелин колец", 1954, "Эпический роман в жанре эпического фэнтези"))
        }
    }

    private fun loadAuthor(book: Book, callback: (Author) -> Unit) {
        thread {
            Thread.sleep(3000)
            callback(Author("Джон Р.Р. Толкин", "Английский писатель, филолог, лингвист"))
        }
    }

    @Suppress("DefaultLocale")
    private fun startTimer() {
        thread {
            var totalSeconds = 0
            while (true) {
                val minutes = totalSeconds / 60
                val seconds = totalSeconds % 60
                timerLabel.text = String.format("Время: %02d:%02d", minutes, seconds)
                Thread.sleep(1000)
                totalSeconds++
            }
        }
    }

}