package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/12
 * Time   :   11:18 上午
 */

fun main() {
    RefiliedTest().doSomething<String>("hello")

    RefiliedTest.test
    RefiliedTest().doSomething<Int>("hello")
}

class RefiliedTest {

    // reified关键字通常与inline函数一起使用。

    // 使用reified关键字声明的类型参数只能在inline函数内部使用

    // 使用reified关键字可以使类型参数在运行时保留其具体类型

    inline fun <reified T> doSomething(value: Any) {
        if (value is T) {
            println("Value is of type T  ${T::class.java}")
        } else {
            println("Value is not of type T  ${T::class.java}")
        }
    }

    companion object {

        // internal const 在 半生对象里  或者  单独类中，参考：ConstsKey.kt

        // 表示一个声明仅在同一个模块中可见

        internal const val test =""

        private const val test2 =""
    }

}