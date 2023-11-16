package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/2/22
 * Time   :   5:52 下午
 */

// 单例类
object ObjectTest {

    val a1 = "a1"

    // 若 java中 调用 需要调用出加 INSTANCE
    @JvmStatic    //若加上这个，则调用处不用加 INSTANCE
    fun getValue() = "aa"

    fun regexExpress() {

        val inputString = "Hello, World!"

        val delimiter = ","

        val splitArray = inputString.split(delimiter.toRegex()).toTypedArray()

        // 输出拆分后的子字符串数组
        for (substring in splitArray) {
            println(substring)
        }

    }
}