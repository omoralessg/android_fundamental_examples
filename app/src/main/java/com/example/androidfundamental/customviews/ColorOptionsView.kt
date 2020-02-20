package com.example.androidfundamental.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.androidfundamental.R

class ColorOptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val mValue: View
    private val mImage: ImageView
    fun setValueColor(color: Int) {
        mValue.setBackgroundColor(color)
    }

    fun setImageVisible(visible: Boolean) {
        mImage.visibility = if (visible) View.VISIBLE else View.GONE
    }

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.ColorOptionsView, 0, 0
        )
        val titleText = a.getString(R.styleable.ColorOptionsView_titleText)
        val valueColor = a.getColor(
            R.styleable.ColorOptionsView_valueColor,
            context.getColor(android.R.color.holo_blue_light)
        )
        a.recycle()
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_color_options, this, true)
        val title = getChildAt(0) as TextView
        title.text = titleText
        mValue = getChildAt(1)
        mValue.setBackgroundColor(valueColor)
        mImage = getChildAt(2) as ImageView
    }
}