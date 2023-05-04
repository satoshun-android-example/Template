package io.github.satoshun.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.satoshun.example.share.network.ExampleService
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
  private val service: ExampleService,
) : ViewModel() {

  init {
    viewModelScope.launch {
      runCatching { service.getGitHub() }
        .onSuccess { println("githubgithub: $it") }
        .onFailure { println("githubgithub: $it") }
    }
  }
}
