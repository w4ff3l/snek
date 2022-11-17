package w4ff3l.snake.ui

import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import w4ff3l.snake.game.Game
import w4ff3l.snake.game.GameConfiguration.boardHeight
import w4ff3l.snake.game.GameConfiguration.boardWidth
import w4ff3l.snake.game.GameConfiguration.titleBarHeight
import w4ff3l.snake.game.model.Direction
import w4ff3l.snake.ui.window.GameBox
import w4ff3l.snake.ui.window.StartDialog
import w4ff3l.snake.ui.window.TitleBar

@Composable
fun ApplicationScope.MainView() {

    val game = remember { Game() }

    MaterialTheme(colors = AppTheme.colors.material) {
        Window(
            onCloseRequest = ::exitApplication,
            state = createWindowState(),
            resizable = false,
            onPreviewKeyEvent = createDirectionKeyEvent(game),
            undecorated = true
        ) {
            LaunchedEffect(Unit) {
                while (true) {
                    withFrameNanos {
                        game.onUpdate(it)
                    }
                }
            }

            WindowDraggableArea {
                TitleBar(game.score)
            }

            if (!game.isRunning()) {
                StartDialog(game)
            }

            GameBox(game)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun createDirectionKeyEvent(game: Game): (KeyEvent) -> Boolean {
    return { keyEvent: KeyEvent ->
        when (keyEvent.key) {
            Key.DirectionLeft -> game.snake.rotate(Direction.LEFT)
            Key.DirectionRight -> game.snake.rotate(Direction.RIGHT)
        }
        false
    }
}

@Composable
fun createWindowState(): WindowState {
    return rememberWindowState(
        width = boardWidth.dp,
        height = boardHeight.dp + titleBarHeight.dp
    )
}
