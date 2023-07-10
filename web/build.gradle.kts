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
    browser()
    binaries.executable()
  }
}
