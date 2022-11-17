package w4ff3l.snake.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.openrndr.math.Vector2
import w4ff3l.snake.game.GameConfiguration.baseSpeed
import w4ff3l.snake.game.GameConfiguration.bodyPartDistance
import w4ff3l.snake.game.GameConfiguration.rotationSpeed
import w4ff3l.snake.game.GameConfiguration.speedStep
import w4ff3l.snake.game.model.Direction

class Snake {

    private var speed by mutableStateOf(baseSpeed)
    private var directionVector = Vector2(1.0, 0.0)
    var body = mutableListOf<Vector2>()
        private set
    var head by mutableStateOf(Vector2(200.0, 200.0))
        private set

    fun move(delta: Float) {
        val deltaSpeed = speed * delta
        head += directionVector.times(deltaSpeed)

        if (body.isEmpty()) return

        var orientation: Vector2 = (head - body.first()).normalized
        if (body[0].distanceTo(head) > bodyPartDistance) {
            body[0] += orientation * deltaSpeed
        }
        for (i in 1 until body.size) {
            if (body[i].distanceTo(body[i - 1]) > bodyPartDistance) {
                orientation = (body[i - 1] - body[i]).normalized
                body[i] += orientation * deltaSpeed
            }
        }
    }

    fun increaseSpeed() {
        speed += speedStep
    }

    fun addBodyPart() {
        when (body.size) {
            0 -> {
                val new = Vector2(head.x - bodyPartDistance, head.y)
                body.add(new)
            }

            1 -> {
                val dir = head - body.first()
                val new = body.last() - (dir.normalized * bodyPartDistance)
                body.add(Vector2(new.x, new.y))
            }

            else -> {
                val dir = body[body.size - 2] - body[body.size - 1]
                val new = body.last() - (dir.normalized * bodyPartDistance)
                body.add(Vector2(new.x, new.y))
            }
        }
    }

    fun rotate(direction: Direction) {
        directionVector = when (direction) {
            Direction.LEFT -> {
                directionVector.rotate(-rotationSpeed)
            }

            Direction.RIGHT -> {
                directionVector.rotate(rotationSpeed)
            }
        }
    }
}