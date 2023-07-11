plugins {
  kotlin("js")
  kotlin("plugin.serialization")

//  id("example.multiplatform.library.compose")

//  kotlin("multiplatform")
//  id("org.jetbrains.compose")
}

dependencies {
  implementation(kotlin("stdlib-js"))
}

kotlin {
  js(IR) {
    moduleName = "sample-browser"

    browser()
    binaries.executable()
  }

  sourceSets {
//    val jsWasmMain by creating {
//      dependencies {
//        implementation(projects.shareUi)
////        implementation(compose.runtime)
////        implementation(compose.ui)
////        implementation(compose.foundation)
////        implementation(compose.material)
////        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
////        implementation(compose.components.resources)
//      }
//    }

//    val jsMain by getting {
//      dependsOn(jsWasmMain)
//    }
  }
}
