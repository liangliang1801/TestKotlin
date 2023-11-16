package com.ramotion.fluidslider.example.simple.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Author :   wutianlong@ushareit.com
 * Date   :   2023/11/10
 * Time   :   4:28 PM
 */
class SelfViewModel : ViewModel() {

    val liveDataInstance = MutableLiveData<String>()
}