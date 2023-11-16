package com.ramotion.fluidslider.example.simple

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ramotion.fluidslider.FluidSlider
import com.ramotion.fluidslider.example.simple.viewmodel.SelfViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG ="wutianlong"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val max = 45
        val min = 10
        val total = max - min

        val slider = findViewById<FluidSlider>(R.id.fluidSlider)
        slider.positionListener = { pos -> slider.bubbleText = "${min + (total  * pos).toInt()}" }
        slider.position = 0.3f
        slider.startText ="$min"
        slider.endText = "$max"

        slider.beginTrackingListener = { textView.visibility = View.INVISIBLE }
        slider.endTrackingListener = { textView.visibility = View.VISIBLE }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.d("wutianlong", "onCreate:  1  "+Thread.currentThread().name)

            withContext(Dispatchers.Main){
                Log.d("wutianlong", "onCreate:  2  "+Thread.currentThread().name)

            }
        }


        lifecycleScope.launchWhenResumed {
            Log.d("wutianlong", "launchWhenResumed.....")

        }


        val model:SelfViewModel = ViewModelProvider(this).get(SelfViewModel::class.java)

        model.liveDataInstance.postValue("aaaa")

        Log.d("wutianlong", " ${model.liveDataInstance.value}")

    }

}
