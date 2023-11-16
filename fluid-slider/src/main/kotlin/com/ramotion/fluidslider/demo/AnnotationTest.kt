package com.ramotion.fluidslider.demo

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/4/19
 * Time   :   11:04 上午
 */
fun main() {
    AnnotationTest().test(UATActionEvent.BACK_PRESSED)
    AnnotationTest().test(UATActionEvent.SCROLL)
    AnnotationTest().test("aaa")

}
class AnnotationTest {

    fun test(@UATActionEvent value: String){
        println(value)
    }


}



@Retention(RetentionPolicy.SOURCE)
annotation class UATActionEvent {
    companion object {
        const val SCROLL = "uat_scroll"
        const val PAGE_IN = "uat_page_in"
        const val PAGE_OUT = "uat_page_out"
        const val CLICK = "uat_click"
        const val BACK_PRESSED = "uat_back_pressed"
    }
}