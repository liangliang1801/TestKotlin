package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/12
 * Time   :   11:40 上午
 */

fun main() {
    UntilTest().one()

    UntilTest().two()

    UntilTest().three()

}


class UntilTest {

    fun one() {

        // 不包括末尾 左闭右开
        for (i in 0 until 5) {
            System.out.println(" ---- $i")
        }

        System.out.println("\n \n \n ")



        // 可以放 不同类型值
        var value = arrayOf("A", "B", 3)

        for (i in 0 until value.size) {
            println(" ~~~~~~  $i   ${value[i]}  ")
        }
    }


    fun two() {

        // 包括末尾  左闭右闭
        val numbers = 0..5

        for (i in numbers) {
            System.out.println(" ====== $i")

        }
    }

    fun three() {

        for (i in 10 downTo 1 step 2) {
            println("***** " + i)
        }
    }
}