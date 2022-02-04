package io.github.satoshun.example

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppContent() {
  Text(text = "Hello World")
}

@Preview
@Composable
fun PreviewAppContent() {
  AppTheme {
    Surface {
      AppContent()
    }
  }
}