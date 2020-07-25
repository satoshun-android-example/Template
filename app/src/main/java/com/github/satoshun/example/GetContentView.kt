package com.github.satoshun.example

import android.app.Activity
import android.view.ViewGroup
import androidx.core.view.get

fun Activity.getContentView() = findViewById<ViewGroup>(android.R.id.content)[0]
