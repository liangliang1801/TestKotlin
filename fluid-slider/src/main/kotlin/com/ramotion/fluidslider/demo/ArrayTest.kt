package com.ramotion.fluidslider.demo

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/3/30
 * Time   :   7:54 下午
 */
fun main() {
    var value = ArrayTest()
    println(" ${value.getArray(1)}  =======   ${value.getList(5)} ")

    value.foreachMap()

    value.testRunCatching()

    value.bianliArray()
}

class ArrayTest {

    val location = intArrayOf(0, 0)


    val arrayCase: Array<String>? = arrayOf("A", "B", "C")

    var listCase: List<Int>? = listOf(1, 2, 3)

    var mapCase: Map<String, Int>? = mapOf(
        "x" to 7,
        "y" to 8,
        "z" to 9
    )

    var linkmap = linkedMapOf<String, Int>("keys" to 2)

    fun bianliArray(){

        for ( (index,value) in arrayCase?.withIndex()!!){

//            if (index == 1)
//                break

            println("$index -> $value")
        }


        for (i in arrayCase.indices){

            println("indices  $i   ${arrayCase[i]}")
        }
    }

    fun getArray(i: Int): String {
        return arrayCase?.get(i) ?: "--------"
    }

    fun getList(i: Int): Int {
        // 越界 后 会 自动返回 ?: 后的值
        return listCase?.getOrNull(i) ?: 66666
    }

    fun foreachMap() {

        //mapTest["portal"] = 5


        listCase?.forEach {
            System.out.println("list foreach = $it")
        }

        listCase?.forEachIndexed { index, value ->
            System.out.println("testlist forEachIndexed  $index   =   $value")
        }


        mapCase?.forEach { (key, value) ->
            System.out.println("...$key.....$value..")
        }

        System.out.println("...${mapCase?.keys}.......")

        System.out.println("...${mapCase?.values}.......")


        mapCase?.forEach {
            println(" ${it.key}   ${it.value}  ")
        }


        // 将Map中的值  转换为 list
        var map_to_list = mapCase?.values?.toMutableList()
        println("map_to_list  ===  $map_to_list")

    }

    fun testRunCatching() {
        kotlin.runCatching {
            System.out.println("--- kotlin.runCatching-----")
        }.onFailure {
            it.printStackTrace()
        }
    }
}