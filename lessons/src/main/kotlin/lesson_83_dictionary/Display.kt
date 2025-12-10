package lesson_83_dictionary

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.awt.BorderLayout
import java.awt.Font
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField

object Display {

    private lateinit var queries: Flow<String>
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val repository = Repository
    private var loadingJob: Job? = null

    private val enterWordLabel = JLabel("Enter word: ").apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 17)
    }
    private val searchField = JTextField(20).apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 17)
        addKeyListener(object : KeyAdapter() {
            override fun keyReleased(p0: KeyEvent?) {
                loadDefinition()
            }
        })
    }
    private val searchButton = JButton("Search").apply {
        addActionListener {
            loadDefinition()
        }
    }
    private val resultArea = JTextArea(25, 50).apply {
        isEditable = false
        lineWrap = true
        wrapStyleWord = true
        font = Font(Font.SANS_SERIF, Font.BOLD, 18)
    }
    private val topPanel = JPanel().apply {
        add(enterWordLabel)
        add(searchField)
        add(searchButton)
    }
    private val mainFrame = JFrame("Dictionary App").apply {
        layout = BorderLayout()
        add(topPanel, BorderLayout.NORTH)
        add(JScrollPane(resultArea), BorderLayout.CENTER)
        pack()
    }

    private fun loadDefinition() {

    }


    fun show() {
        mainFrame.isVisible = true
    }

    init {
        queries.onEach {
            searchButton.isEnabled = false
            resultArea.text = "Loading..."
        }.map {
            repository.loadDefinition(it)
        }.map {
            it.joinToString("\n\n").ifEmpty { "Not found" }
        }.onEach {
            resultArea.text = it
            searchButton.isEnabled = true
        }.launchIn(scope)
    }
}

fun main() {
    Display.show()
}