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
import w4ff3l.snake.game.GameConfiguration.foodSize

@Composable
fun FoodBox(position: Vector2) {
    Box(
        Modifier
            .offset(
                position.x.dp,
                position.y.dp
            )
            .size(foodSize.dp)
            .clip(CircleShape)
            .background(Color(0, 0, 0))
    )
}
