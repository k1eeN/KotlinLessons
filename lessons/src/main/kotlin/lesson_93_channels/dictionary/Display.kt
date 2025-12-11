package lesson_93_channels.dictionary

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
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


@OptIn(FlowPreview::class)
object Display {

    private val queries = MutableSharedFlow<String>()
    private val state = MutableStateFlow<ScreenState>(ScreenState.Initial)
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val repository = Repository

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
        scope.launch {
            queries.emit(searchField.text.trim())
        }
    }


    fun show() {
        mainFrame.isVisible = true
    }

    init {
        queries.onEach {
            state.emit(ScreenState.Loading)
        }.debounce(500)
            .map {
                if (it.isEmpty()) {
                    state.emit(ScreenState.Initial)
                } else {
                    val result = repository.loadDefinition(it)
                    if (result.isEmpty()) {
                        state.emit(ScreenState.NotFound)
                    } else {
                        state.emit(ScreenState.DefinitionsLoaded(result))
                    }
                }
            }.retry {
                println(it)
                state.emit(ScreenState.Error)
                true
            }.launchIn(scope)

        state.onEach {
            when (it) {

                is ScreenState.DefinitionsLoaded -> {
                    resultArea.text = it.definition.joinToString("\n\n")
                    searchButton.isEnabled = true
                }

                ScreenState.Initial -> {
                    resultArea.text = ""
                    searchButton.isEnabled = false
                }

                ScreenState.Loading -> {
                    resultArea.text = "Loading..."
                    searchButton.isEnabled = false
                }

                ScreenState.NotFound -> {
                    resultArea.text = "Not found"
                    searchButton.isEnabled = true
                }

                ScreenState.Error -> {
                    resultArea.text = "Something went wrong"
                    searchButton.isEnabled = true
                }
            }
        }.launchIn(scope)
    }
}

fun main() {
    Display.show()
}