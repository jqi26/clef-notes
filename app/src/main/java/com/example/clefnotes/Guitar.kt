package com.example.clefnotes

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout

class Guitar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val highEStringFret1: Button
    private val highEStringOpen: Button

    init {
        inflate(context, R.layout.guitar, this)

        highEStringFret1 = findViewById(R.id.highEStringFret1)
        highEStringOpen = findViewById(R.id.highEStringOpen)

        setUpGuitar()
    }

    private fun setUpGuitar() {
        highEStringOpen.setOnClickListener {
            if (highEStringFret1.isPressed) {
                println("f")
            } else {
                println("e")
            }
        }
    }
}