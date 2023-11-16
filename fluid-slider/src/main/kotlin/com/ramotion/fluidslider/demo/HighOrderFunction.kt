package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/3/9
 * Time   :   5:10 下午
 */

fun main() {
//    HighOrderFunction().test()
    HighOrderFunction().test2()
}


class HighOrderFunction {

    fun order(v1: String, functions: (v2: Int, v3: String) -> String) {

        // 以下二种调用方式一样，触发外部做动作 ，或  取外部的 返回值

        // var result = functions.invoke(2, "aa")

        var result = functions(2, "aa")

        System.out.println(" $v1  ______  $result")
    }

    fun test() {
        order("bb", { v2, v3 ->
            System.out.println(" $v2  $v3")

            "$v2" + v3
        })
    }

    fun test2() {

        // 参数顺序可以改变，通过 参数名 指定即可

        order(functions = { v2, v3 ->
            System.out.println(" $v2  $v3")

            "$v2" + v3
        }, v1 = "bb")
    }

}