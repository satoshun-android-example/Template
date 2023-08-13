package io.github.satoshun.example.share

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ShareUI(onClick: () -> Unit) {
  Button(onClick = onClick) {
    Text(text = "Navigate")
  }
}

@Composable
fun ShareUIPreview() {
  MaterialTheme {
    ShareUI {}
  }
}
