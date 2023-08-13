package io.github.satoshun.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
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
  Scaffold { paddingValues ->
    Row(
      Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Column(Modifier.fillMaxSize()) {
        TopAppBar(title = {
          Text(text = "Sample")
        })

        Text(text = "Hello World")
        ShareUI2()
        ShareUI(onNavigate)
      }
    }
  }
}
