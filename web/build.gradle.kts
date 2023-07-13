plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

//private val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
//  from(project(":share-ui").file("src/commonMain/resources"))
//  into("build/processedResources/js/main")
//:}
//
//afterEvaluate {
//  project.tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
//}

kotlin {
  js(IR) {
    moduleName = "sample-browser"
    browser()
    binaries.executable()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(projects.shareUi)

        implementation(compose.runtime)
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.material3)
        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        implementation(compose.components.resources)
      }
    }
  }
}

compose.experimental {
  web.application {}
}

compose {
  kotlinCompilerPlugin.set(libs.versions.wasmCompose.get())
  val kotlinVersion = libs.versions.kotlin.get()
  kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
}
