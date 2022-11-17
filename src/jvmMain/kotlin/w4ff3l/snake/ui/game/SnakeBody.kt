package w4ff3l.snake.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.openrndr.math.Vector2
import w4ff3l.snake.game.GameConfiguration.snakeSize

@Composable
fun SnakeBody(head: Vector2, body: List<Vector2>) {
    CircleShape(head.x, head.y)

    body.forEach {
        CircleShape(it.x, it.y)
    }
}

@Composable
private fun CircleShape(x: Double, y: Double) {
    Box(
        Modifier
            .offset(x.dp, y.dp)
            .size(snakeSize.dp)
            .clip(CircleShape)
            .background(Color(0, 255, 0))
    )
}