plugins {
  alias(libs.plugins.android.app) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.dagger.hilt) apply false
  alias(libs.plugins.napt) apply false
}

allprojects {
  repositories {
    google()
    mavenCentral()

//    maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
  }

  // https://issuetracker.google.com/issues/194113162
//  tasks.withType<JavaCompile>().configureEach {
//    javaCompiler = javaToolchains.compilerFor {
//      languageVersion = JavaLanguageVersion.of(11)
//    }
//  }
}
