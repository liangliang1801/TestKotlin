package com.ramotion.fluidslider.demo;


import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/2/23
 * Time   :   11:06 上午
 */
class TestJava {
    public static void main(String[] args) {
        Test t= new Test();

    /*  若在 kt 中这样写

            val function: () -> Unit = {
                    Unit
            }
    */

        t.setListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return Unit.INSTANCE;
            }
        });



        ObjectTest.INSTANCE.getA1();
        ObjectTest.getValue();

        ObjectTest.INSTANCE.regexExpress();
    }
}
