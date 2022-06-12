buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(libs.android.gradle)
    classpath(libs.kotlin.gradle)
    classpath(libs.android.dagger.hilt.gradle)
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()

    maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
      jvmTarget = JavaVersion.VERSION_11.toString()

      freeCompilerArgs += listOf(
        "-Xopt-in=kotlin.RequiresOptIn",

        // https://mobile.twitter.com/ZacSweers/status/1520399593577582593
        "-Xsam-conversions=class",

//          "-Xuse-k2",

//          "-P",
//          "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true",
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
