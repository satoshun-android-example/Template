package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.example.share.Share
import io.github.satoshun.example.theme.AppTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
  private val viewModel: AppViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println(Share)
    println(viewModel)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      AppTheme {
        AppContent()
      }
    }
  }
}
