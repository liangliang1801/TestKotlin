package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/11/13
 * Time   :   10:45 AM
 */
fun main() {

//    val result = setForEach()
//    println("result = $result")


//    val listresult = listForEach()
//    println("listresult = $listresult")


    selfDefineReturn()

}

// 标签处返回  return  则直接意思是 整个方法的返回值
fun setForEach(): String {

    val test = setOf<String>("a", "b", "c", "d", "e", "f", "g")

    test.forEach { s ->

        run {
            if (s == "c")
                return s

            println(" value =  $s")
        }
    }

    return "setForEach"
}


// 标签处返回  return@forEach  相当于continue
fun listForEach(): String {
    val test = mutableListOf<String>("1", "2", "3", "4")
    test.add("5")

    test.forEach {

        if (it == "2")
            return@forEach

        println(" value = ${it}")
    }

    return "listForEach"
}


fun selfDefineReturn() {
    val test = mutableListOf<Int>(1, 2, 3, 4, 5, 6)

    run loop@{

        test.forEachIndexed { index, i ->
            run {
                if (i == 4)
                    return@forEachIndexed     // 打印 1 2 3 5 6
//                    return@loop                 // 打印 1 2 3

                println("  $i")
            }
        }

    }
}