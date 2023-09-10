package io.github.satoshun.example.share.animate

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AnimateTest4() {
  var moved by remember { mutableStateOf(false) }
  val pxToMove = with(LocalDensity.current) {
    100.dp.toPx().roundToInt()
  }
  val offset by animateIntOffsetAsState(
    targetValue = if (moved) {
      IntOffset(pxToMove, pxToMove)
    } else {
      IntOffset.Zero
    },
    label = "offset"
  )
}
