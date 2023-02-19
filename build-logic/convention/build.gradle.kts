plugins {
  `kotlin-dsl`
}

group = "io.github.satoshun.example.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "example.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }
    register("androidLibrary") {
      id = "example.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
  }
}
