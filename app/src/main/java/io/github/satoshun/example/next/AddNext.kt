package io.github.satoshun.example.next

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.addNext(navController: NavHostController) {
  navigation(route = "next", startDestination = "next1") {
    composable(
      "next1",
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
      Next1()
    }
  }
}

@Composable
fun Next1() {
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
