package io.github.satoshun.example.share.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ShareUI() {
  Text(text = "ShareUI")
}

@Composable
fun ShareUIPreview() {
  MaterialTheme {
    ShareUI()
  }
}
