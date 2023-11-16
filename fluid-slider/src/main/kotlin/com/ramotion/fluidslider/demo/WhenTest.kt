package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/4
 * Time   :   10:42 上午
 */

fun main() {
    var instance = WhenTest()

    instance.whenCaseWithParams(2)

    instance.WhenCaseNoParam()

    instance.ifCase(2, 3)
}


class WhenTest {


    fun whenCaseWithParams(value: Any) {

        // 可以 赋值给某个变量
        // when 后 有参数
        var first = when (value) {

            in 1..10 -> {
                System.out.println("in 1..10")
                10
            }

            !in 2..3 -> {
                System.out.println("!in 2..3")
                2
            }

            is String -> {
                System.out.println("is string")
                "string5"
            }

            else -> {
                System.out.println("not is string")
                5
            }
        }

        System.out.println("$first")
    }

    // when 也可以用来取代 if-else if链。 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：
    fun WhenCaseNoParam() {

        when {

            x is Int -> System.out.println("x is int")

            !(y is String) -> System.out.println(" y not is string")

            else -> System.out.println(" others")
        }
    }


    fun ifCase(a: Int, b: Int) {

        var value = if (a < b) 111 else 222

        System.out.println("  ifCase $value")
    }

    companion object {
        var x: Any = 1
        var y: Any = "string"
    }
}