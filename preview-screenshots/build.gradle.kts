plugins {
  id("example.android.library")
  id("example.android.library.compose")
  id("example.android.dagger")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.paparazzi)
}

android {
  namespace = "io.github.satoshun.example.share"
}

dependencies {
  implementation(libs.bundles.android.ui)

  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)

  implementation(libs.showkase.runtime)
  ksp(libs.showkase.processor)

  testImplementation(libs.android.test.runner)
  testImplementation(libs.testParameterInjector)
}
