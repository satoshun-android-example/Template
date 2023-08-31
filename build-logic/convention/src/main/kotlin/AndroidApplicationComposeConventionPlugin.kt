import com.android.build.api.dsl.ApplicationExtension
import io.github.satoshun.example.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply("com.android.application")
      extensions.configure<ApplicationExtension> {
        configureAndroidCompose(this)
      }
    }
  }
}
