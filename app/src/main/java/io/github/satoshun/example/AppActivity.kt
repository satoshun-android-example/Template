package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.example.share.Share
import javax.inject.Inject

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {
  @Inject lateinit var viewModel: AppViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println(Share)

    setContent {
      AppTheme {
        AppContent()
      }
    }
  }
}
