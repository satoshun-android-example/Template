plugins {
  id("example.android.application")
  id("example.android.application.compose")
  id("example.android.dagger")
}

android {
  namespace = "io.github.satoshun.example"

  defaultConfig {
    applicationId = "io.github.satoshun.example"
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  packaging {
    resources.excludes += listOf(
      "META-INF/AL2.0",
      "META-INF/LGPL2.1"
    )
  }

  testOptions {
    unitTests {
      isIncludeAndroidResources = true
    }
  }
}

dependencies {
  implementation(projects.share2)
  implementation(projects.shareUi)

  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)

  debugImplementation(libs.bundles.android.debug.test)
  debugImplementation(libs.leakcanary)

  testImplementation(libs.bundles.test)

  androidTestImplementation(libs.bundles.android.test)
}
