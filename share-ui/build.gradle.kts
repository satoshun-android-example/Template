import org.jetbrains.compose.compose

plugins {
  id("example.multiplatform.library")
  id("example.multiplatform.library.compose")
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
        implementation(projects.share)

        api(compose.runtime)
        api(compose.ui)
        api(compose.foundation)
        api(compose.animation)
        api(compose.animationGraphics)
        api(compose.material3)

        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        api(compose.components.resources)

        api(compose("org.jetbrains.compose.ui:ui-util"))
        api(compose("org.jetbrains.compose.ui:ui-graphics"))
        api(compose("org.jetbrains.compose.ui:ui-text"))
        api(compose("org.jetbrains.compose.ui:ui-unit"))
      }
    }
    val wasmMain by getting {
      dependsOn(commonMain)
    }
    val jsMain by getting {
      dependsOn(wasmMain)
    }
  }
}

android {
  namespace = "io.github.satoshun.example.share.ui"
}
