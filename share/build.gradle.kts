plugins {
  id("example.android.library")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.kapt)
}

dependencies {
  implementation(libs.dagger.hilt.android)
  kapt(libs.dagger.hilt.compiler)
}

