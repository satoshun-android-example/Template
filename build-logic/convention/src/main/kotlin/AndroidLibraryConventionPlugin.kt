import com.android.build.gradle.LibraryExtension
import com.google.samples.apps.nowinandroid.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
        apply("com.google.devtools.ksp")
        apply("kotlinx-serialization")
        apply("com.squareup.sort-dependencies")
      }

      extensions.configure<LibraryExtension> {
        configureKotlinAndroid(this)
        defaultConfig.targetSdk = 34
      }
    }
  }
}
