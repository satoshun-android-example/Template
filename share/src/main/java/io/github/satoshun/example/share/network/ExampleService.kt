package io.github.satoshun.example.share.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ExampleService @Inject constructor() {
  private val client = HttpClient(OkHttp) {
    install(ContentNegotiation) {
      json(Json {
        prettyPrint = true
        isLenient = true
      })
    }
  }

  suspend fun getUser(): User {
    return client.get("https://example.com/users") {
      contentType(ContentType.Application.Json)
    }.body()
  }
}

@Serializable
data class User(
  val id: Int,
  val name: String,
)
