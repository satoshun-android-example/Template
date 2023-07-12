plugins {
//  kotlin("js")
//  kotlin("plugin.serialization")

//  id("example.multiplatform.library.compose")

  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

kotlin {
//  js(IR) {
//    moduleName = "sample-browser"
//    browser()
//    binaries.executable()
//  }

  wasm {
    moduleName = "sample-browser"
    browser()
    binaries.executable()
  }

  sourceSets {
    val wasmMain by getting {
      dependencies {
        implementation(compose.runtime)
        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.material3)

        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        implementation(compose.components.resources)
      }
    }

//    val jsWasmMain by creating {
//      dependencies {
//        implementation(projects.shareUi)
////        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
////        implementation(compose.components.resources)
//      }
//    }

//    val jsMain by getting {
//      dependsOn(jsWasmMain)
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
