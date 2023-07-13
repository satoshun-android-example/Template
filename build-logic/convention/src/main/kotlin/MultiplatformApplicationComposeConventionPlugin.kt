import io.github.satoshun.example.configureMultiplatformCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.compose.ComposeExtension

class MultiplatformApplicationComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("kotlin-multiplatform")
        apply("org.jetbrains.compose")
      }

      extensions.configure<ComposeExtension> {
        configureMultiplatformCompose(this)
      }
    }
  }
}