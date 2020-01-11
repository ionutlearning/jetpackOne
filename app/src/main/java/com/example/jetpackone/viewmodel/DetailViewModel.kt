package com.example.jetpackone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackone.model.DogBreed

class DetailViewModel : ViewModel() {
    val detail = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed("1", "tekel", "15 years", "group", "for", "temp", "")
        detail.value = dog
    }
}