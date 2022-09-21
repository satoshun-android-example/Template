plugins {
  id("example.android.library")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.kotlin.kapt)
}

dependencies {
  implementation(libs.android.dagger.hilt.android)
  kapt(libs.android.dagger.hilt.compiler)
}

