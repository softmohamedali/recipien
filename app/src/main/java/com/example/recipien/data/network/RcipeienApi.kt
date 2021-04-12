package com.example.recipien.data.network

import com.example.recipien.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface RcipeienApi {

    @GET("recipes/complexSearch")
    suspend fun getFoodRecepien(
        @QueryMap query:Map<String,String>
    ):Response<FoodRecipe>
}