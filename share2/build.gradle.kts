plugins {
  id("example.multiplatform.library")
//  id("example.multiplatform.library.compose")
  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  android()

  sourceSets {
    val commonMain by getting
    val androidMain by getting {
      dependencies {
        implementation(libs.ktor.android)
        implementation(libs.ktor.okhttp)
        implementation(libs.ktor.serialization)
        implementation(libs.ktor.negotiation)
        implementation(libs.ktor.json)
      }
    }
  }
}

android {
  namespace = "io.github.satoshun.example.share2"
}
