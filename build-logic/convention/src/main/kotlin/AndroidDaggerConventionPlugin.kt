import io.github.satoshun.example.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDaggerConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.google.dagger.hilt.android")
        apply("org.jetbrains.kotlin.kapt")
      }
      dependencies {
        add("implementation", libs.findLibrary("dagger-hilt-android").get())
        add("kapt", libs.findLibrary("dagger-hilt-compiler").get())
      }
    }
  }
}
