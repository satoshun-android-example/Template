package com.github.satoshun.example.sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.SampleFragBinding

class SampleFragment : Fragment(R.layout.sample_frag) {
  private val binding: SampleFragBinding get() = SampleFragBinding.bind(requireView())

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
