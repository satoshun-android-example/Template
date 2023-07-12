dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
  }
  versionCatalogs {
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}

rootProject.name = "build-logic"

include(":convention")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
