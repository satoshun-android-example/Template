package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.example.share.Share
import io.github.satoshun.example.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
  @Inject lateinit var viewModel: AppViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println(Share)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      AppTheme {
        AppContent()
      }
    }
  }
}
