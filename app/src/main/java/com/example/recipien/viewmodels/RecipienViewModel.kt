package com.example.recipien.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.recipien.utils.Constances

class RecipienViewModel(application: Application):AndroidViewModel(application) {
    fun applyQuery():HashMap<String,String>
    {

        val query=HashMap<String,String>()
        query[Constances.Query_NUMBER]="50"
        query[Constances.Query_APIKEY]= Constances.API_KEY
        query[Constances.Query_TYPE]="drink"
        query[Constances.Query_DIET]="vegan"
        query[Constances.Query_ADD_RECIPE_INFO]="true"
        query[Constances.Query_FILL_INGREDIENT]="true"
        return query
    }
}