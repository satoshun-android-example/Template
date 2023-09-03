package io.github.satoshun.example.share.animate

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateTest3() {
  var animateBackgroundColor by remember {
    mutableStateOf(false)
  }
  val animateColor by animateColorAsState(
    targetValue = if (animateBackgroundColor) Color.Magenta else Color.Yellow,
    label = "color"
  )
  Box(
    Modifier
      .size(100.dp)
      .drawBehind {
        drawRect(animateColor)
      }
      .clickable {
        animateBackgroundColor = !animateBackgroundColor
      }
  )
}
