package w4ff3l.snake.ui

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

object AppTheme {

    val colors: Colors = Colors()

    class Colors(
        private val background: Color = Color(0xFF282828),
        private val primary: Color = Color(0xFFfabd2f),
        private val secondary: Color = Color(0xFFb8bb26),

        val material: androidx.compose.material.Colors = darkColors(
            background = background,
            primary = primary,
            secondary = secondary
        )
    )
}