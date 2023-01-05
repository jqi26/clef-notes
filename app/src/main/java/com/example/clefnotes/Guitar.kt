package com.example.clefnotes

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout

class Guitar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val highEStringFret1: Button
    private val highEStringFret2: Button
    private val highEStringFret3: Button
    private val highEStringOpen: Button
    private val bStringFret3: Button

    lateinit var delegate: GuitarListenerDelegate

    init {
        inflate(context, R.layout.guitar, this)

        highEStringFret1 = findViewById(R.id.highEStringFret1)
        highEStringFret2 = findViewById(R.id.highEStringFret2)
        highEStringFret3 = findViewById(R.id.highEStringFret3)
        highEStringOpen = findViewById(R.id.highEStringOpen)
        bStringFret3 = findViewById(R.id.bStringFret3)

        setUpGuitar()
    }

    private fun setUpGuitar() {
        highEStringOpen.setOnClickListener {
            if (highEStringFret1.isPressed) {
                delegate.didPlayNote(Note.HIGH_F)
            } else if (highEStringFret2.isPressed) {
                delegate.didPlayNote(Note.OTHER)
            } else if (highEStringFret3.isPressed) {
                delegate.didPlayNote(Note.HIGH_G)
            } else if (bStringFret3.isPressed) {
                delegate.didPlayNote(Note.HIGH_D)
            } else {
                delegate.didPlayNote(Note.HIGH_E)
            }
        }
    }
}