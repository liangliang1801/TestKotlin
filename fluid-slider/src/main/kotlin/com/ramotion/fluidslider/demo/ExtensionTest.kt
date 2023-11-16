package com.ramotion.fluidslider.demo

import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.StringBuilder

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/11/16
 * Time   :   10:37 AM
 */

fun main() {
    println("abcdefg".insertCharBetweenString { value -> "$value---" })

    Thread {
        println(Thread.currentThread().name)
    }.start()

    test(1, "longshao") { value ->
        println("testinvoke")
        "$value ===== returnvalue"
    }
}


fun String.insertCharBetweenString(block: (Char) -> String): String {

    var builder = StringBuilder()

    for (i in indices) {

        if (i != indices.last) {  // indices.last 代表最后一个索引下标，若字符串长度是5  ，则last代表4
            builder.append(block.invoke(get(i)))

        } else {
            builder.append(get(i))
        }
    }

    return builder.toString()
}

fun test(a:Int,b:String, block: (String) -> String){
    println(block.invoke( "$a--$b"))
}


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}