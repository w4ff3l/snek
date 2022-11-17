package w4ff3l.snake.game.util

import org.openrndr.math.Vector2
import w4ff3l.snake.game.GameConfiguration.boardHeight
import w4ff3l.snake.game.GameConfiguration.boardWidth
import w4ff3l.snake.game.GameConfiguration.foodSize
import w4ff3l.snake.game.GameConfiguration.snakeSize
import w4ff3l.snake.game.Snake

fun hasCollidedWithFieldSide(snake: Snake): Boolean {
    snake.head.apply {
        if (x + snakeSize > boardWidth ||
            x < 0 ||
            y + snakeSize > boardHeight ||
            y < 0
        ) {
            return true
        }
    }
    return false
}

fun hasCollidedWithFood(snake: Snake, currentFood: Vector2): Boolean {
    return circlesOverlap(snake.head, snakeSize, currentFood, foodSize)
}

fun hasCollidedWithItself(snake: Snake): Boolean {
    if (snake.body.size < 3) return false

    snake.apply {
        for (i in 3 until body.size) {
            if (circlesOverlap(snake.head, snakeSize, snake.body[i], snakeSize))
            return true
        }
    }

    return false
}

private fun circlesOverlap(position1: Vector2, radius1: Float, position2: Vector2, radius2: Float): Boolean {
    return position1.distanceTo(position2) < (radius1 / 2 + radius2 / 2)
}
