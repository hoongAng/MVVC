package com.example.mvvc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel :ViewModel(){
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count//this is a getter

    fun increment(){
        _count.value = _count.value?.plus(1)
    }

    fun decrement(){
        _count.value = _count.value?.minus(1)
    }

    init{
        _count.value = 0
        Log.d("MVVC","ViewModel initialised")
    }

    override fun onCleared() {
        Log.d("MVVC", "ViewModel cleared")
        super.onCleared()
    }
}