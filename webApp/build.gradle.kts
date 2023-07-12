import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
//  kotlin("js")
//  kotlin("plugin.serialization")

//  id("example.multiplatform.library.compose")

  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

//private val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
//  from(project(":share-ui").file("src/commonMain/resources"))
//  into("build/processedResources/js/main")
//}
//
//private val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
//  from(project(":share-ui").file("src/commonMain/resources"))
//  into("build/processedResources/wasm/main")
//}
//
//afterEvaluate {
//  project.tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
//  project.tasks.getByName("wasmProcessResources").finalizedBy(copyWasmResources)
//}

kotlin {
  js(IR) {
    moduleName = "sample-browser"
    browser()
    binaries.executable()
  }

  wasm {
    moduleName = "sample-browser"
    browser {
      commonWebpackConfig {
        devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
//                    open = mapOf(
//                        "app" to mapOf(
//                            "name" to "google chrome canary",
//                            "arguments" to listOf("--js-flags=--experimental-wasm-gc ")
//                        )
//                    ),
          static = (devServer?.static ?: mutableListOf()).apply {
            // Serve sources to debug inside browser
            add(project.rootDir.path)
            add(project.rootDir.path + "/share-ui/")
            add(project.rootDir.path + "/nonAndroidMain/")
            add(project.rootDir.path + "/webApp/")
          },
        )
      }
    }
    binaries.executable()
  }

  sourceSets {
    val wasmMain by getting {
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

    val jsMain by getting {
      dependsOn(wasmMain)
    }

//    val jsWasmMain by creating {
//      dependencies {
//        implementation(projects.shareUi)
////        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
////        implementation(compose.components.resources)
//      }
//    }
  }
}

//dependencies {
//  implementation(kotlin("stdlib-js"))
//}

compose.experimental {
  web.application {}
}

compose {
  kotlinCompilerPlugin.set(libs.versions.wasmCompose.get())
  val kotlinVersion = libs.versions.kotlin.get()
  kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
}
