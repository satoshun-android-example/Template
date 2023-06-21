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
  compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "example.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }
    register("androidApplicationCompose") {
      id = "example.android.application.compose"
      implementationClass = "AndroidApplicationComposeConventionPlugin"
    }

    register("androidLibrary") {
      id = "example.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
    register("androidLibraryCompose") {
      id = "example.android.library.compose"
      implementationClass = "AndroidLibraryComposeConventionPlugin"
    }

    register("androidDagger") {
      id = "example.android.dagger"
      implementationClass = "AndroidDaggerConventionPlugin"
    }
  }
}
