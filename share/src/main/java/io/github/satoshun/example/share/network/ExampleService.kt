package io.github.satoshun.example.share.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ExampleService @Inject constructor() {
  private val client = HttpClient(OkHttp) {
    install(ContentNegotiation) {
      json(Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
      })
    }
  }

  suspend fun getGitHub(): GitHub {
    return client.get("https://api.github.com") {
      contentType(ContentType.Application.Json)
    }.body()
  }
}

@Serializable
data class GitHub(
  @SerialName("current_user_url") val currentUserUrl: String,
)
