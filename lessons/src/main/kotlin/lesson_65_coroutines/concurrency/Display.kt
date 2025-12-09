package lesson_65_coroutines.concurrency

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lesson_65_coroutines.entities.Book
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.util.concurrent.Executors
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea

object Display {

    private val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    private val scope = CoroutineScope(CoroutineName("My coroutine") + dispatcher)

    private val infoArea = JTextArea().apply {
        isEditable = false
        font = Font(Font.SANS_SERIF, Font.BOLD, 18)
    }
    private val loadButton = JButton("Загрузить книгу").apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 15)

        addActionListener {
            isEnabled = false
            infoArea.text = "Идет загрузка информации о книге...\n"


            val jobs = mutableListOf<Deferred<Book>>()
            repeat(10) { it ->
                scope.async {
                    val book = loadBook()
                    infoArea.append("Книга $it: ${book.title}\nГод: ${book.year}\nЖанр: ${book.genre}\n\n")
                    book
                }.also { jobs.add(it) }
            }
            scope.launch {
                val books = jobs.awaitAll()
                println(books.joinToString(", "))
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

    private fun longOperation() {
        mutableListOf<Int>().apply {
            repeat(300_000) {
                add(0, it)
            }
        }
    }

    private suspend fun loadBook(): Book {
        withContext(Dispatchers.Default) {
            longOperation()
        }
        return Book("Властелин колец", 1954, "Эпический роман в жанре эпического фэнтези")
    }


    @Suppress("DefaultLocale")
    private fun startTimer() {
        scope.launch {
            var totalSeconds = 0
            while (true) {
                val minutes = totalSeconds / 60
                val seconds = totalSeconds % 60
                timerLabel.text = String.format("Время: %02d:%02d", minutes, seconds)
                delay(1000)
                totalSeconds++
            }
        }
    }

}

