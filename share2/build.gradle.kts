plugins {
  id("example.multiplatform.library")
  id("example.multiplatform.library.compose")

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
        implementation(compose.runtime)
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.animation)
        implementation(compose.animationGraphics)
        implementation(compose.material3)
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
  namespace = "io.github.satoshun.example.share2"
}
