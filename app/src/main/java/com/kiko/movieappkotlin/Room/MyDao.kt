package com.kiko.movieappkotlin.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kiko.movieappkotlin.modelclass.MovieModel

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movieModel: MovieModel)

    @Query("select * from MovieModel")
    suspend fun getMovie():MovieModel
}