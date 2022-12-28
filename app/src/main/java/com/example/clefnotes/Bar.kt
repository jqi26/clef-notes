package com.example.clefnotes

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class Bar  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {


    init {
        inflate(context, R.layout.bar, this)
    }
}