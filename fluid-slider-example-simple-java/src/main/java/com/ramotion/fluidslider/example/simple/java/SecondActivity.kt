package com.ramotion.fluidslider.example.simple.java

import android.app.Activity
import android.os.Bundle
import android.view.View

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/3
 * Time   :   3:44 下午
 */
class SecondActivity : Activity() {

    lateinit var slider: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slider = findViewById<View>(R.id.fluidSlider)

        slider.visibility = View.VISIBLE

        slider.setOnClickListener {
            it.visibility = View.GONE
        }
    }
}