plugins {
  id("example.android.application")

  alias(libs.plugins.dagger.hilt)
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

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
  }

  testOptions {
    unitTests {
      isIncludeAndroidResources = true
    }
  }
}

dependencies {
  api(platform(libs.compose.bom))

  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)
  implementation(libs.dagger.hilt.android)
  implementation(projects.share)

  debugImplementation(libs.bundles.android.debug.test)
  debugImplementation(libs.leakcanary)

  kapt(libs.dagger.hilt.compiler)

  testImplementation(libs.bundles.test)

  androidTestImplementation(libs.bundles.android.test)
}
