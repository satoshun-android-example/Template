package io.github.satoshun.example.share.animate

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimateTest2() {
  var visible by remember { mutableStateOf(false) }
  val animatedAlpha by animateFloatAsState(
    targetValue = if (visible) 1.0f else 0f,
    label = "alpha"
  )

  Row {
    Box(
      modifier = Modifier
        .size(100.dp)
        .background(Color.Green)
        .clickable { visible = !visible },
    )
    Box(
      modifier = Modifier
        .size(100.dp)
        .graphicsLayer {
          alpha = animatedAlpha
        }
        .background(Color.Red),
    )
  }
}
