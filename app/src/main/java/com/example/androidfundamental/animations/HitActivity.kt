package com.example.androidfundamental.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.androidfundamental.R
import java.util.*

class HitActivity : Activity() {
    private lateinit var animation1: ObjectAnimator
    private lateinit var animation2: ObjectAnimator
    private lateinit var button: Button
    private lateinit var randon: Random
    private var width = 0
    private var height = 0
    private lateinit var set: AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.target)
        width = windowManager.defaultDisplay.width
        height = windowManager.defaultDisplay.height
        randon = Random()
        set = createAnimation()
        set.start()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                val nextX = randon.nextInt(width)
                val nextY = randon.nextInt(height)
                animation1 = ObjectAnimator.ofFloat(
                    button, "x", button.x,
                    nextX.toFloat()
                )
                animation1.setDuration(1400)
                animation2 = ObjectAnimator.ofFloat(
                    button, "y", button.y,
                    nextY.toFloat()
                )
                animation2.setDuration(1400)
                set.playTogether(animation1, animation2)
                set.start()
            }
        })
    }

    fun onClick(view: View?) {
        val string = button.text.toString()
        val hitTarget = Integer.valueOf(string) + 1
        button.text = hitTarget.toString()
    }

    private fun createAnimation(): AnimatorSet {
        val nextX = randon.nextInt(width)
        val nextY = randon.nextInt(height)
        button = findViewById(R.id.button1)
        animation1 = ObjectAnimator.ofFloat(button, "x", nextX.toFloat())
        animation1.setDuration(1400)
        animation2 = ObjectAnimator.ofFloat(button, "y", nextY.toFloat())
        animation2.setDuration(1400)
        val set = AnimatorSet()
        set.playTogether(animation1, animation2)
        return set
    }
}