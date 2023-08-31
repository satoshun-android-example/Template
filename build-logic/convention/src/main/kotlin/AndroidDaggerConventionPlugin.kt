import io.github.satoshun.example.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidDaggerConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.google.dagger.hilt.android")
        apply("com.google.devtools.ksp")
      }
      dependencies {
        add("implementation", libs.findLibrary("dagger-hilt-android").get())
        add("ksp", libs.findLibrary("dagger-hilt-compiler").get())
      }
    }
  }
}
