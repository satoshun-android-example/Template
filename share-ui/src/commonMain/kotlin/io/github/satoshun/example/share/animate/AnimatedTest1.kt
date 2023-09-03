package io.github.satoshun.example.share.animate

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.unit.dp

@Composable
fun AnimateTest1() {
  var visible by remember {
    mutableStateOf(false)
  }
  Row {
    AnimatedVisibility(visible) {
      Box(
        Modifier
          .size(100.dp)
          .background(Color.Blue)
          .clickable { visible = !visible },
      )
    }
    Box(
      Modifier
        .size(100.dp)
        .background(Color.Red)
        .clickable { visible = !visible },
    )
    AnimatedVisibility(visible) {
      Box(
        Modifier
          .size(100.dp)
          .background(Color.Blue)
          .clickable { visible = !visible },
      )
    }
  }
}
