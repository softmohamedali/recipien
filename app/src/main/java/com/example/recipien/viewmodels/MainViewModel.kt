package com.example.recipien.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.recipien.data.DataSourceRepo
import com.example.recipien.models.FoodRecipe
import com.example.recipien.utils.Networkresult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor( //cheak here if foun error
    application:Application,
    private val repo:DataSourceRepo
) :AndroidViewModel(application) {
    var response:MutableLiveData<Networkresult<FoodRecipe>> = MutableLiveData()

    fun getRecipe(queri:Map<String,String>)
    {
        viewModelScope.launch {
            getRecipeSafeCall(queri)
        }
    }

    private suspend fun getRecipeSafeCall(queri: Map<String, String>)
    {
        response.value=Networkresult.Loading()
        if (cheackInterntConnection()) {
            try{
                val resp=repo.remoteeDataSource.recipeApi.getFoodRecepien(queri)
                response.value=handleResponseVlue(resp)
            }catch (e:Exception){
                response.value=Networkresult.Error("recipe not found")
            }
        }
        else{
            response.value=Networkresult.Error("No internet Access.")
        }
    }

    private fun handleResponseVlue(resp: Response<FoodRecipe>): Networkresult<FoodRecipe>? {
        when{
            resp.message().contains("timeout") ->{
                return Networkresult.Error("time out")
            }
            resp.code() ==402 ->{
                return Networkresult.Error("api key is limited ")
            }
            resp.body()!!.results.isNullOrEmpty()->{
                return Networkresult.Error("recipe not found")
            }
            resp.isSuccessful ->{
                return Networkresult.Success(resp.body()!!)
            }
            else -> {
                return Networkresult.Error(resp.message())
            }
        }
    }

    private fun cheackInterntConnection():Boolean {
        val connectivityManager=getApplication<Application>()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetWork=connectivityManager.activeNetwork?:return true
        val capabilitiesNetwork=connectivityManager.getNetworkCapabilities(activeNetWork)?:return true

        return when
        {
            capabilitiesNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)-> true
            capabilitiesNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)-> true
            capabilitiesNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)-> true
            else -> false
        }
    }
}