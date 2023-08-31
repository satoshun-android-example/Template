import com.android.build.gradle.LibraryExtension
import com.google.samples.apps.nowinandroid.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class MultiplatformLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("kotlin-multiplatform")
        apply("com.android.library")
      }

      extensions.configure<LibraryExtension> {
        configureKotlinAndroid(this)
      }
    }
  }
}
