package io.github.satoshun.example

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.satoshun.example.home.addHome
import io.github.satoshun.example.next.addNext
import io.github.satoshun.example.theme.AppTheme

@Composable
fun AppContent() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "home",
  ) {
    addHome(navController)
    addNext(navController)
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
