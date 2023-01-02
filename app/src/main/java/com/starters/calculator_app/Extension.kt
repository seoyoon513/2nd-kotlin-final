package com.starters.calculator_app

import android.animation.ObjectAnimator
import androidx.appcompat.widget.AppCompatButton

fun AppCompatButton.sizeScaleAnimation(endSize: Float, durationInMilliSec: Long) {
    val animator = ObjectAnimator.ofFloat(this, "textSize", endSize)
    animator.start()
}