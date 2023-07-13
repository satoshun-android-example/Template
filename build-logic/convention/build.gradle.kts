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
  compileOnly(libs.compose.gradlePlugin)
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

    register("multiplatformCompose") {
      id = "example.multiplatform.library"
      implementationClass = "MultiplatformLibraryConventionPlugin"
    }
    register("multiplatformLibraryCompose") {
      id = "example.multiplatform.library.compose"
      implementationClass = "MultiplatformLibraryComposeConventionPlugin"
    }
    register("multiplatformApplicationCompose") {
      id = "example.multiplatform.application.compose"
      implementationClass = "MultiplatformApplicationComposeConventionPlugin"
    }
  }
}
