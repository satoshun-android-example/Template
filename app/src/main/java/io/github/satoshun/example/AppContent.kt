package io.github.satoshun.example

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.satoshun.example.home.addHome
import io.github.satoshun.example.theme.AppTheme

@Composable
fun AppContent() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "home",
  ) {
    addHome(navController)

    composable(
      "next",
      enterTransition = {
        slideIn(
          initialOffset = { IntOffset(0, it.height) },
          animationSpec = tween(2000)
        )
      },
      exitTransition = {
        slideOut(
          targetOffset = { IntOffset(0, it.height) },
          animationSpec = tween(3000)
        )
      },
    ) {
      Scaffold { paddingValues ->
        Column(
          Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
          Text(text = "Next")
        }
      }
    }
  }
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
