plugins {
  `kotlin-dsl`
}

apply {
  plugin("kotlin")
}

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation(gradleApi())
}
