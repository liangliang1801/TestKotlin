package com.ramotion.fluidslider.demo

import android.util.Log
import android.util.Pair

// 这个类里 不用写 类名
fun outerImport(a: Int, b: String, c: Pair<Boolean, Int>): String {

    val test = Pair.create(1, 2)
    Log.d("long", "outerImport: ${test.first}    ${test.second}")

    return when (a) {
        1 -> "aa"
        2 -> "bb"
        else -> "cc"
    }
}