package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/4
 * Time   :   11:35 上午
 */

fun main() {
    var instance = DataTest(a = 1, b = "bbbbb")

    instance.age = 1

    // DataTest(a=1, b=bbbbb)
    System.out.println(instance.toString())

    System.out.println("name = ${instance.age}")

    System.out.println(" instance = ${instance.hashCode().toString(16)} ")


    var instance2 = instance.copy()

    System.out.println(" instance2 = ${instance2.hashCode().toString(16)} ")

    System.out.println(" 值是否相等  2 个等号  " + (instance == instance2))

    System.out.println(" 地址 是否相等  3 个等号  " + (instance === instance2))


    var instance3 = DataTest(instance2)
    System.out.println(" 值是否相等  2 个等号  " + (instance3 == instance2))
    System.out.println(" 地址 是否相等  3 个等号  " + (instance3 === instance2))
}

// 构造参数中必须用  var or val 声明    c 指定了默认值
data class DataTest(var a: Int, var b: String? = null, var c: Boolean = false) {

    constructor(other: DataTest) : this(other.a, other.b)

    init {
        System.out.println(" enter init //////////// ")
    }

    // 必须要给初始值
    var age: Int = 0
        get() {
            return field + 10 +a
        }
        // value 代表传入的值    field代表属性值
        set(value) {
            if (value >= 10)
                field = 1
            else
                field = 2
        }

}