package io.github.satoshun.example.share.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ExampleService {
  suspend fun getUsers(): List<User> {
    val client = HttpClient(OkHttp) {
      install(ContentNegotiation) {
        json(Json {
          prettyPrint = true
          isLenient = true
        })
      }
    }
    return client.get("https://example.com/users").body()
  }
}

data class User(
  val id: Int,
  val name: String
)
