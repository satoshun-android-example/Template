plugins {
  alias(libs.plugins.android.app) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.dagger.hilt) apply false
}

allprojects {
  repositories {
    google()
    mavenCentral()

//    maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
      jvmTarget = JavaVersion.VERSION_11.toString()

      freeCompilerArgs += listOf(
        "-opt-in=kotlin.RequiresOptIn",

        // https://mobile.twitter.com/ZacSweers/status/1520399593577582593
        "-Xsam-conversions=class",

//          "-Xuse-k2",

          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true",
      )
    }
  }

  // https://issuetracker.google.com/issues/194113162
  tasks.withType<JavaCompile>().configureEach {
//    javaCompiler = javaToolchains.compilerFor {
//      languageVersion = JavaLanguageVersion.of(11)
//    }
  }
}
