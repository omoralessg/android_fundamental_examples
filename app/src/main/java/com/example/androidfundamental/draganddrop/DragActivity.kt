package com.example.androidfundamental.draganddrop

import android.app.Activity
import android.content.ClipData
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.androidfundamental.R


class DragActivity : Activity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag)
        findViewById<View>(R.id.myimage1).setOnTouchListener(MyTouchListener())
        findViewById<View>(R.id.myimage2).setOnTouchListener(MyTouchListener())
        findViewById<View>(R.id.myimage3).setOnTouchListener(MyTouchListener())
        findViewById<View>(R.id.myimage4).setOnTouchListener(MyTouchListener())
        findViewById<View>(R.id.topleft).setOnDragListener(MyDragListener())
        findViewById<View>(R.id.topright).setOnDragListener(MyDragListener())
        findViewById<View>(R.id.bottomleft).setOnDragListener(MyDragListener())
        findViewById<View>(R.id.bottomright).setOnDragListener(MyDragListener())
    }

    private inner class MyTouchListener : OnTouchListener {
        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                val data = ClipData.newPlainText("", "")
                val shadowBuilder = DragShadowBuilder(
                    view
                )
                view.startDrag(data, shadowBuilder, view, 0)
                view.visibility = INVISIBLE
                true
            } else {
                false
            }
        }
    }

    internal inner class MyDragListener : OnDragListener {
        var enterShape = resources.getDrawable(
            R.drawable.shape_droptarget
        )
        var normalShape = resources.getDrawable(R.drawable.shape)
        override fun onDrag(v: View, event: DragEvent): Boolean {
            val action: Int = event.getAction()
            when (event.getAction()) {
                DragEvent.ACTION_DRAG_STARTED -> {
                }
                DragEvent.ACTION_DRAG_ENTERED -> v.setBackgroundDrawable(enterShape)
                DragEvent.ACTION_DRAG_EXITED -> v.setBackgroundDrawable(normalShape)
                DragEvent.ACTION_DROP -> {
                    // Dropped, reassign View to ViewGroup
                    val view = event.getLocalState() as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)
                    val container = v as LinearLayout
                    container.addView(view)
                    view.visibility = VISIBLE
                }
                DragEvent.ACTION_DRAG_ENDED -> v.setBackgroundDrawable(normalShape)
                else -> {
                }
            }
            return true
        }
    }
}
