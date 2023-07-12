plugins {
  id("example.multiplatform.library")
  id("example.multiplatform.library.compose")
}

kotlin {
  android()

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(libs.jetbrains.compose.foundation)
        implementation(libs.jetbrains.compose.material)
      }
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
