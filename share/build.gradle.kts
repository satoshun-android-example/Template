plugins {
  id("example.android.library")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.napt)
}

android {
  namespace = "io.github.satoshun.example.share"
}

dependencies {
  implementation(libs.dagger.hilt.android)
  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)

  annotationProcessor(libs.dagger.hilt.compiler)
}
