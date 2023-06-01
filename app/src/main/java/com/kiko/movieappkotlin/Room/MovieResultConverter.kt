package com.kiko.movieappkotlin.Room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kiko.movieappkotlin.modelclass.MovieModel

class MovieResultConverter {
    @TypeConverter
    fun fromListToString(list:List<MovieModel.Result>):String{
        return Gson().toJson(list)
    }
    @TypeConverter
    fun fromStringToList(s:String):List<MovieModel.Result>{
        val type=object : TypeToken<List<MovieModel.Result>>() {}.type
        return Gson().fromJson(s,type)
    }
}