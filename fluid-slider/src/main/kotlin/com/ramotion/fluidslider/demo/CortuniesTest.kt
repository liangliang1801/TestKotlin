package com.ramotion.fluidslider.demo

import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Date

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/11/13
 * Time   :   9:48 AM
 */
fun main() {

//    orderInvoke()

    togetherInvoke()

//    messageInCoroutines()
}

const val TAG = "coroutinesTest"


// 协程 顺序执行任务  主要使用 async  await
fun orderInvoke() = runBlocking {

    launch {
        val job1 = async {
            println("$TAG  job1 start    ${Date()}      ${System.currentTimeMillis()}")
            delay(5_000)
            println("$TAG  job1  end  ${Date()}     ")
        }.await()


        val job2 = async {
            println("$TAG JOB2 start    ${Date()}     ")

            delay(3_000)

            println("$TAG JOB2  end   ${Date()}  ")
        }.await()


        println("$TAG 都完成啦")
    }
}


// 同一个协程里 同时  并发执行，一起执行 多个任务
// await 里面才有 suspend ，才是真正发起异步任务执行的
fun togetherInvoke() = runBlocking {

    val job1 = async {
        println("$TAG  job1 start    ${Date()}      ${System.currentTimeMillis()}")
        delay(5_000)
        println("$TAG  job1  end  ${Date()}     ")
    }


    val job2 = async {
        println("$TAG JOB2 start    ${Date()}     ")

        delay(3_000)

        println("$TAG JOB2  end   ${Date()}  ")
    }

    val result1 = job1.await()
    val result2 = job2.await()

    println("$TAG together all finished    ${Date()}  ")
}


// 协程间通信  通过Channel
fun messageInCoroutines() = runBlocking {

    val selfChannel = Channel<Int>()

    launch {

        for (item in 1..10) {
            selfChannel.send(item)
            println(" send $item")
        }

        selfChannel.close()
    }


    launch {
        for (item in selfChannel) {
            println(" receive $item")
        }
    }


}