package w4ff3l.snake.ui.window

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import w4ff3l.snake.ui.game.SnakeBody
import w4ff3l.snake.game.Game
import w4ff3l.snake.game.GameConfiguration.boardHeight
import w4ff3l.snake.game.GameConfiguration.boardWidth
import w4ff3l.snake.game.GameConfiguration.titleBarHeight
import w4ff3l.snake.ui.game.FoodBox

@Composable
fun GameBox(game: Game) {
    Row(modifier = Modifier.offset(y = titleBarHeight.dp)) {
        Box(
            Modifier
                .background(Color(100, 100, 100))
                .width(Dp(boardWidth.toFloat()))
                .height(Dp(boardHeight.toFloat()))
        ) {
            SnakeBody(game.snake.head, game.snake.body)
            FoodBox(game.currentFood)
        }
    }
}