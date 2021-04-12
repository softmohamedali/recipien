package com.example.recipien

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipien.models.FoodRecipe
import com.example.recipien.utils.Constances

@Entity(tableName = Constances.NAME_TABLE)
class ReciepEntity (var foodRecipe: FoodRecipe){

    @PrimaryKey(autoGenerate = false)
    var id:Int=0
}