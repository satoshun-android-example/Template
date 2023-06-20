package io.github.satoshun.example.share.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShareUI() {
  Text(text = "ShareUI")
}

@Preview
@Composable
fun ShareUIPreview() {
  MaterialTheme {
    ShareUI()
  }
}
