package com.example.recipien.utils

class Constances {
    companion object{
        const val BASE_URL="https://api.spoonacular.com"
        const val API_KEY="edbeeb052f9c4b4dbdaa8ed780ac4083"

        //number=1&apiKey=edbeeb052f9c4b4dbdaa8ed780ac4083&type=drink&diet=vegan&addRecipeInformation=true&fillIngredients=true
        //Query
        const val Query_NUMBER="number"
        const val Query_APIKEY="apiKey"
        const val Query_TYPE="type"
        const val Query_DIET="diet"
        const val Query_ADD_RECIPE_INFO="addRecipeInformation"
        const val Query_FILL_INGREDIENT="fillIngredients"

        //Room
        const val NAME_DB="recipe_db"
        const val NAME_TABLE="recipe_table"

    }
}