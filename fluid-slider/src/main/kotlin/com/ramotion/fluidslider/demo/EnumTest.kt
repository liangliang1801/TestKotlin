package com.ramotion.fluidslider.demo

import java.io.Serializable

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/2/22
 * Time   :   5:43 下午
 */
enum class EnumTest(var s: String):Serializable {

    A("1"), B("2");

    fun value(): String {
        return s
    }

    fun value2() = s



    companion object {

        fun valueOf(role:String):EnumTest?{

            values().forEach {
                if (it.s == role) {
                    return it
                }
            }

            return null
        }
    }
}