package lesson_65_coroutines.coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import lesson_65_coroutines.entities.Author
import lesson_65_coroutines.entities.Book
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import kotlin.concurrent.thread

object Display {

    private val scope = CoroutineScope(CoroutineName("My coroutine"))

    private val infoArea = JTextArea().apply {
        isEditable = false
        font = Font(Font.SANS_SERIF, Font.BOLD, 18)
    }
    private val loadButton = JButton("Загрузить книгу").apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 15)

        addActionListener {
            scope.launch {
                isEnabled = false
                infoArea.text = "Идет загрузка информации о книге...\n"
                val book = loadBook()
                infoArea.append("Книга: ${book.title}\nГод: ${book.year}\nЖанр: ${book.genre}\n")
                infoArea.append("Идет загрузка информации о авторе...\n")
                val author = loadAuthor(book)
                infoArea.append("Автор: ${author.name}\nБиография: ${author.bio}\n")
                isEnabled = true
            }
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
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = BorderLayout()
        add(topPanel, BorderLayout.NORTH)
        add(JScrollPane(infoArea), BorderLayout.CENTER)
        size = Dimension(600, 600)
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(p0: WindowEvent?) {
                scope.cancel()
            }
        })
    }

    fun show() {
        mainFrame.isVisible = true
        startTimer()
    }

    private suspend fun loadBook(): Book {
        delay(3000)
        return Book("Властелин колец", 1954, "Эпический роман в жанре эпического фэнтези")
    }

    private suspend fun loadAuthor(book: Book): Author {
        delay(3000)
        return Author("Джон Р.Р. Толкин", "Английский писатель, филолог, лингвист")
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