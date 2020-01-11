package com.example.jetpackone.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogsApi {
    @GET("devtides/dogsapi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}