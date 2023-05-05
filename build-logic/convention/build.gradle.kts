plugins {
  `kotlin-dsl`
}

group = "io.github.satoshun.example.buildlogic"

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
  compileOnly(libs.sortDependencies.gradlePlugin)
  compileOnly(libs.napt.gradlePlugin)
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
