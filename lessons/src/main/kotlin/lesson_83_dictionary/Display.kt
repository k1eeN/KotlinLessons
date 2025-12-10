package lesson_83_dictionary

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField

object Display {

    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    val repository = Repository

    private val enterWordLabel = JLabel("Enter word: ").apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 17)
    }
    private val searchField = JTextField(20).apply {
        font = Font(Font.SANS_SERIF, Font.PLAIN, 17)
    }
    private val searchButton = JButton("Search").apply {
        addActionListener {
            scope.launch {
                isEnabled = false
                resultArea.text = "Loading..."
                val word = searchField.text.trim()
                val definition = repository.loadDefinition(word).joinToString("\n\n")
                resultArea.text = definition.ifEmpty { "Not found" }
                isEnabled = true
            }
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

    fun show() {
        mainFrame.isVisible = true
    }

}

fun main() {
    Display.show()
}