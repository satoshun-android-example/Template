plugins {
  id("example.android.library")

  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.napt)
}

dependencies {
  implementation(libs.dagger.hilt.android)
  annotationProcessor(libs.dagger.hilt.compiler)
}
