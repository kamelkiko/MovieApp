package com.kiko.movieappkotlin.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kiko.movieappkotlin.modelclass.MovieModel

@Database(entities = arrayOf(MovieModel::class), version = 1)
@TypeConverters(MovieResultConverter::class)
abstract class MyDataBase : RoomDatabase(){
    abstract fun getDao():MyDao
    companion object{
        private lateinit var myDataBase: MyDataBase
        fun initDataBase(context: Context){
            myDataBase= Room.databaseBuilder(context,MyDataBase::class.java,"movie")
                .fallbackToDestructiveMigration()
                .build()
        }
        fun getDataBase()= myDataBase
    }
}