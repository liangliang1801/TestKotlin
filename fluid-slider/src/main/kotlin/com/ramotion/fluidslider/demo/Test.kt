package com.ramotion.fluidslider.demo

import android.os.Build
import java.security.Key
import com.ramotion.fluidslider.demo.outerImport
import android.util.Pair
/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/2/17
 * Time   :   11:03 上午
 */

fun main() {
    var instance = Test()

    instance.testListener = { value ->
        System.out.println("listener response test: $value ")
        System.out.println("listener response ====== ${Test.values}")

    }
    kotlin.runCatching { }.getOrNull()
    instance.test()

    System.out.println(" lazyTest  invoke --111-- ${instance.lazyTest}")
    System.out.println(" lazyTest  invoke --2222-- ${instance.lazyTest}")

    var testmap = LinkedHashMap<String, String>()
    testmap["aa"] = "bb"

    instance.longshao = 2
    System.out.println(" longshao =  ${instance.longshao}")

    // 这里可以直接调用，但是java中调用必须 通过 setListener
    instance.listener = {}

    // 直接引用外部类方法，需要本类手动 import ,然后直接调用此方法，相当于工具方法一样
    outerImport(1,"test",Pair.create(false,0))
}


class Test {

    var listener: (() -> Unit)? = null

    // 属性委托，只在首次调用才会计算 并初始化，之后再调用直接用之前的数值
    val lazyTest: Boolean by lazy {

        val enuminvoke = EnumTest.A
        enuminvoke.value()

        var firstOrnull = EnumTest.values().firstOrNull()
        firstOrnull?.s="9999"

        System.out.println(" lazyTest  enter ...... ${firstOrnull?.s}")

        val a = 1
        val b = 2
        a <= b ?: return@lazy false
        true
    }

    val listtest = mutableListOf("1", "2222").filter { it.length >= 3 }

    val testlist = listOf<Int>(1, 2, 3, 4, 100, 200).filter { it >= 5 }

    var s = if (listener == null) {
        System.out.println("w")
        2
    } else 3

    var svalue = when (s) {
        2 -> true
        3 -> false
        else -> true
    }

    fun test() {

        val mutabmapval = mutableMapOf(
            "1" to "b",
            "2" to "c"
        ).apply {
            put("33","CCC")
            put("44","DDDD")
        }


        mutabmapval["1"] = "aaa"
        System.out.println(mutabmapval["1"])

        mutabmapval.forEach {
            System.out.println(" map ........  ${it.key}   ${it.value} ")
        }


//        listtest.add(1, "aaaaa")
        listtest.forEachIndexed { index, s ->
            System.out.println("wutianlong test: $index   $s")


        }

        listtest.let {
            it.forEachIndexed { index, s -> }
        }

        with(listtest) {
//            removeAt(0)
        }

        System.out.println("wutianlong test: ${listtest.get(0)}  ")

        testListener?.invoke(3.0f)

        ObjectTest.getValue()
        ObjectTest.a1

        var logo: Int? = 0
        when (logo) {
            0 -> {}

            1 -> {}

            else -> {}
        }

    }

    var testListener: ((Float) -> Unit)? = null

    var longshao: Int? = 0
        get() {
            if (field == null)
                return 4
            else
                return field!! * 5
        }
        set(value) {
            if (value != null) {
                if (value > 10)
                    field = 1
                else
                    field = 2
            }
        }

    companion object {
        val values = "this is companion object"
    }
}