package com.example.androidfundamental.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamental.R

class AnimationExampleActivity : AppCompatActivity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_example)

        // Get the support action bar
        val actionBar = supportActionBar
        actionBar?.show()

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Kotlin"
        actionBar.subtitle = "Many useful kotlin examples."
        actionBar.elevation = 4.0F
    }

    fun startAnimation(view: View) {
        var dest = 0f
        val aniView =
            findViewById<View>(R.id.imageView1) as ImageView
        when (view.id) {
            R.id.Button01 -> {
                dest = 360f
                if (aniView.rotation == 360f) {
                    println(aniView.alpha)
                    dest = 0f
                }
                val animation1 = ObjectAnimator.ofFloat(
                    aniView,
                    "rotation", dest
                )
                animation1.duration = 2000
                animation1.start()
            }
            R.id.Button02 -> {
                // shows how to define a animation via code
// also use an Interpolator (BounceInterpolator)
                val paint = Paint()
                val aniTextView =
                    findViewById<View>(R.id.textView1) as TextView
                val measureTextCenter = paint.measureText(
                    aniTextView.text
                        .toString()
                )
                dest = 0 - measureTextCenter
                if (aniTextView.x < 0) {
                    dest = 0f
                }
                val animation2 = ObjectAnimator.ofFloat(
                    aniTextView,
                    "x", dest
                )
                animation2.duration = 2000
                animation2.start()
            }
            R.id.Button03 -> {
                // demonstrate fading and adding an AnimationListener
                dest = 1f
                if (aniView.alpha > 0) {
                    dest = 0f
                }
                val animation3 = ObjectAnimator.ofFloat(
                    aniView,
                    "alpha", dest
                )
                animation3.duration = 2000
                animation3.start()
            }
            R.id.Button04 -> {
                val fadeOut = ObjectAnimator.ofFloat(
                    aniView, "alpha",
                    0f
                )
                fadeOut.duration = 2000
                val mover = ObjectAnimator.ofFloat(
                    aniView,
                    "translationX", -500f, 0f
                )
                mover.duration = 2000
                val fadeIn = ObjectAnimator.ofFloat(
                    aniView, "alpha",
                    0f, 1f
                )
                fadeIn.duration = 2000
                val animatorSet = AnimatorSet()
                animatorSet.play(mover).with(fadeIn).after(fadeOut)
                animatorSet.start()
            }
            else -> {
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.animation_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                val intent = Intent(this, HitActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}