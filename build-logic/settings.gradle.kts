dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
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
