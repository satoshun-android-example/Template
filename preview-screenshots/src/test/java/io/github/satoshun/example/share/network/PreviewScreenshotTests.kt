package io.github.satoshun.example.share.network

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Density
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameter.TestParameterValuesProvider
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class ComponentPreview(
  private val showkaseBrowserComponent: ShowkaseBrowserComponent
) {
  val content: @Composable () -> Unit = showkaseBrowserComponent.component
  override fun toString(): String = showkaseBrowserComponent.componentKey
}

@RunWith(TestParameterInjector::class)
class PreviewScreenshotTests {

  object PreviewProvider : TestParameterValuesProvider {
    override fun provideValues(): List<ComponentPreview> =
      Showkase.getMetadata().componentList.map(::ComponentPreview)
  }

  @get:Rule
  val paparazzi = Paparazzi(
    maxPercentDifference = 0.001,
  )

  @Test
  fun previewTests(
    @TestParameter(valuesProvider = PreviewProvider::class) componentPreview: ComponentPreview,
  ) {
    paparazzi.snapshot {
      CompositionLocalProvider(
        LocalInspectionMode provides true,
        LocalDensity provides Density(
          density = LocalDensity.current.density,
          fontScale = 1.0f,
        )
      ) {
        Box {
          componentPreview.content()
        }
      }
    }
  }
}
