plugins {
  id("example.android.library")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.paparazzi)
}

android {
  namespace = "io.github.satoshun.example.share"

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
  }
}

dependencies {
  implementation(projects.share)

  api(platform(libs.compose.bom))
  implementation(libs.bundles.android.ui)

  implementation(libs.dagger.hilt.android)
  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)

  kapt(libs.dagger.hilt.compiler)

  implementation(libs.showkase.runtime)
  ksp(libs.showkase.processor)

  testImplementation(libs.android.test.runner)
  testImplementation(libs.testParameterInjector)
}
