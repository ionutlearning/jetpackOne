package com.example.jetpackone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackone.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed("1", "tekel", "15 years", "group", "for", "temp", "")
        val dog2 = DogBreed("2", "pitbull", "12 years", "group", "for", "temp", "")
        val dog3 = DogBreed("3", "ogar", "5 years", "group", "for", "temp", "")
        val dog4 = DogBreed("4", "terier", "2 years", "group", "for", "temp", "")
        val dogList = arrayListOf(dog1, dog2, dog3, dog4)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }
}