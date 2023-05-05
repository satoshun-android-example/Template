/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid

import com.android.build.api.dsl.CommonExtension
import com.slapin.napt.NaptGradleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import java.io.File

/**
 * Configure base Kotlin with Android options
 */
internal fun Project.configureKotlinAndroid(
  commonExtension: CommonExtension<*, *, *, *>,
) {
  with(commonExtension) {
    compileSdk = 33

    defaultConfig {
      minSdk = 30
    }

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
      jvmTarget = JavaVersion.VERSION_17.toString()

      // Treat all Kotlin warnings as errors (disabled by default)
      // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
      val warningsAsErrors: String? by project
      allWarningsAsErrors = warningsAsErrors.toBoolean()

      freeCompilerArgs = freeCompilerArgs + listOf(
        "-opt-in=kotlin.RequiresOptIn",
        // Enable experimental coroutines APIs, including Flow
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview",
        "-opt-in=kotlin.Experimental",
        // Enable experimental kotlinx serialization APIs
        "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",

        // https://mobile.twitter.com/ZacSweers/status/1520399593577582593
        "-Xsam-conversions=class",

        "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
        "-opt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi",
      )

      freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
    }
  }

  pluginManager.withPlugin("com.sergei-lapin.napt") {
    configure<NaptGradleExtension> {
      generateNaptTrigger.set(false)
    }
  }
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
  (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

private fun Project.buildComposeMetricsParameters(): List<String> {
  val metricParameters = mutableListOf<String>()
  val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
  val enableMetrics = (enableMetricsProvider.orNull == "true")
  if (enableMetrics) {
    val metricsFolder = File(project.buildDir, "compose-metrics")
    metricParameters.add("-P")
    metricParameters.add(
      "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
    )
  }

  val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
  val enableReports = (enableReportsProvider.orNull == "true")
  if (enableReports) {
    val reportsFolder = File(project.buildDir, "compose-reports")
    metricParameters.add("-P")
    metricParameters.add(
      "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
    )
  }
  return metricParameters.toList()
}
