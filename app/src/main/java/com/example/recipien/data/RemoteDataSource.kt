package com.example.recipien.data

import com.example.recipien.data.network.RcipeienApi
import com.example.recipien.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    var recipeApi: RcipeienApi
){

    suspend fun getRecipe(querie:Map<String,String>):Response<FoodRecipe>
    {
        return recipeApi.getFoodRecepien(querie)
    }

}