package w4ff3l.snake.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.openrndr.math.Vector2
import w4ff3l.snake.game.GameConfiguration.boardHeight
import w4ff3l.snake.game.GameConfiguration.boardWidth
import w4ff3l.snake.game.GameConfiguration.speedInterval
import w4ff3l.snake.game.model.GameState
import w4ff3l.snake.game.util.hasCollidedWithFieldSide
import w4ff3l.snake.game.util.hasCollidedWithFood
import w4ff3l.snake.game.util.hasCollidedWithItself
import kotlin.random.Random

class Game {

    private var previousTime = 0L
    private var gameState by mutableStateOf(GameState.STOPPED)
    var currentFood by mutableStateOf(spawnFood())
    var snake by mutableStateOf(Snake())
    var score by mutableStateOf(0)

    fun start() {
        gameState = GameState.STARTED
    }

    private fun stop() {
        gameState = GameState.STOPPED
    }

    fun initializeGame() {
        snake = Snake()
        score = 0
    }

    fun isRunning(): Boolean {
        return gameState == GameState.STARTED
    }

    fun onUpdate(time: Long) {
        val delta = time - previousTime
        val floatDelta = (delta / 1E8).toFloat()
        previousTime = time

        if (gameState == GameState.STARTED) {

            snake.move(floatDelta)

            if (hasCollidedWithItself(snake)) {
                println("Snake collided with itself.")
                stop()
            }

            if (hasCollidedWithFieldSide(snake)) {
                println("Snake collided with field side")
                stop()
            }

            if (hasCollidedWithFood(snake, currentFood)) {
                currentFood = spawnFood()
                score++
                snake.addBodyPart()

                if (isSpeedStepScore()) {
                    snake.increaseSpeed()
                }
            }
        }
    }

    private fun isSpeedStepScore(): Boolean {
        return score % speedInterval == 0
    }

    private fun spawnFood(): Vector2 {
        return Vector2(
            Random.nextDouble(boardHeight.toDouble() - 50),
            Random.nextDouble(boardWidth.toDouble() - 50)
        )
    }
}