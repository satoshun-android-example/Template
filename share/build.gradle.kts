plugins {
  id("example.multiplatform.library")

  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  androidTarget()
  js(IR) {
    browser()
  }
  wasm {
    browser()
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
      }
    }

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
  namespace = "io.github.satoshun.example.share"
}
