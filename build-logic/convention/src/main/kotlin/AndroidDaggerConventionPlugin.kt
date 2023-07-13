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
        apply("com.google.devtools.ksp")
      }
      dependencies {
//        add("implementation", "com.google.dagger:dagger:2.46.1")
//        add("implementation", "com.google.dagger:hilt-android:2.46.1")

        add("implementation", libs.findLibrary("dagger-hilt-android").get())
        add("kapt", libs.findLibrary("dagger-hilt-compiler").get())

//        add("kapt", "com.google.dagger:hilt-compiler:HEAD-SNAPSHOT")

//        add("implementation", "com.google.dagger:hilt-android:HEAD-SNAPSHOT")
//        add("ksp", "com.google.dagger:hilt-compiler:HEAD-SNAPSHOT")
      }
    }
  }
}
