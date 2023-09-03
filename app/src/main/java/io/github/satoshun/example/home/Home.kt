package io.github.satoshun.example.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.github.satoshun.example.share.animate.AnimateTest1
import io.github.satoshun.example.share.ShareUI
import io.github.satoshun.example.share.ShareUI2

fun NavGraphBuilder.addHome(navController: NavHostController) {
  navigation(route = "home", startDestination = "top") {
    composable("top") {
      Home(onNavigate = {
        navController.navigate("next")
      })
    }
  }
}

@Composable
fun Home(onNavigate: () -> Unit) {
  Scaffold(
    topBar = {
      TopAppBar(title = {
        Text(text = "Sample")
      })
    },
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = paddingValues
    ) {
      item { Text(text = "Hello World") }
      item { ShareUI2() }
      item { ShareUI(onNavigate) }
      item { AnimateTest1() }

      items((1..100).map { it }) {
        Text(text = "Hello World $it")
      }
    }
  }
}
