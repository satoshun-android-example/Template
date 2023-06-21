plugins {
  id("example.android.library")
  id("example.android.library.compose")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.paparazzi)
}

android {
  namespace = "io.github.satoshun.example.share"
}

dependencies {
  implementation(projects.share)

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
