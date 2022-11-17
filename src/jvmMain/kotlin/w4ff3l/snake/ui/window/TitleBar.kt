package w4ff3l.snake.ui.window

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ApplicationScope
import w4ff3l.snake.game.GameConfiguration.titleBarHeight

@Composable
fun ApplicationScope.TitleBar(score: Int) {
    Box(Modifier.fillMaxWidth().height(titleBarHeight.dp).background(Color.DarkGray)) {
        Text(
            "Score: $score",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            CloseButton()
        }
    }
}

@Composable
private fun ApplicationScope.CloseButton() {
    Button(onClick = {
        exitApplication()
    }) { Text("Close") }
}
