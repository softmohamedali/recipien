package com.example.recipien

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipeEntitiy:ReciepEntity)

    @Query("SELECT * FROM recipe_table ORDER BY id ASC")
    fun getRecipe():Flow<List<ReciepEntity>>

}