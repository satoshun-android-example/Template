package io.github.satoshun.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.satoshun.example.theme.AppTheme

@Composable fun AppContent() {
  Scaffold { paddingValues ->
    Row(
      Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Column(Modifier.fillMaxSize()) {
        TopAppBar(
          title = {
            Text(text = "Sample")
          }
        )

        Text(text = "Hello World")
      }
    }
  }
}

@Preview @Composable fun PreviewAppContent() {
  AppTheme {
    Surface {
      AppContent()
    }
  }
}
