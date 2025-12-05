package lesson_35_design_patterns.users

import lesson_35_design_patterns.observer.Observer
import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class Display {

    fun show() {

        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SANS_SERIF, Font.PLAIN, 24)
            margin = Insets(32, 32, 32, 32)
        }

        val scrollPane = JScrollPane(textArea)
        JFrame().apply {
            isVisible = true
            size = Dimension(900, 900)
            add(scrollPane)
        }

        UsersRepository.getInstance("qwerty").addOnUserChangedListener { users ->
            users.joinToString("\n").let { textArea.text = it }
        }
    }
}