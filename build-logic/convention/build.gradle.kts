plugins {
  `kotlin-dsl`
}

group = "io.github.satoshun.example.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
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
  }
}
