buildscript {
  repositories {
    google()
    mavenCentral()
  }
}

plugins {
  alias(libs.plugins.android.app) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.dagger.hilt) apply false
  alias(libs.plugins.dependencyAnalysis)
  alias(libs.plugins.sortDependencies)
}
