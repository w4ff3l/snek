package w4ff3l.snake.ui.window

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Popup
import w4ff3l.snake.game.Game

@Composable
fun StartDialog(game: Game) {
    Popup(alignment = Alignment.Center) {
        Button(onClick = {
            game.initializeGame()
            game.start()
        }) {
            Text(text = "Start Game")
        }
    }
}
