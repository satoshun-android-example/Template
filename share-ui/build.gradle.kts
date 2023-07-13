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
        implementation(compose.runtime)
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.animation)
        implementation(compose.animationGraphics)
        implementation(compose.material3)

        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        implementation(compose.components.resources)
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

compose {
  kotlinCompilerPlugin.set(libs.versions.wasmCompose.get())
  val kotlinVersion = libs.versions.kotlin.get()
  kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
}
