import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.satoshun.example.share.ShareUI2

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  CanvasBasedWindow {
    ShareUI2()
  }
}
