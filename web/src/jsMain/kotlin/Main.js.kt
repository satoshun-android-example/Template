import androidx.compose.foundation.layout.Column
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.satoshun.example.share.ShareUI2
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  onWasmReady {
    CanvasBasedWindow {
      Column {
        ShareUI2()
        ShareUI2()
        ShareUI2()
        ShareUI2()
        ShareUI2()
        ShareUI2()
      }
    }
  }
}
