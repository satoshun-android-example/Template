import com.android.build.gradle.LibraryExtension
import io.github.satoshun.example.configureMultiplatformCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.jetbrains.compose.ComposeExtension

@Suppress("unused")
class MultiplatformLibraryComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("kotlin-multiplatform")
        apply("com.android.library")
        apply("org.jetbrains.compose")
      }

      extensions.configure<ComposeExtension> {
        configureMultiplatformCompose(this)
      }

      extensions.configure<LibraryExtension> {
        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

        packagingOptions.resources.excludes.add("META-INF/*")
      }
    }
  }
}
