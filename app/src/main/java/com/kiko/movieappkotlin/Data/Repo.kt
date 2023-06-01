package com.kiko.movieappkotlin.Data

import androidx.lifecycle.MutableLiveData
import com.kiko.movieappkotlin.API.Retro
import com.kiko.movieappkotlin.Room.MyDataBase
import com.kiko.movieappkotlin.modelclass.MovieModel

class Repo {
    val movieLiveData=MutableLiveData<ArrayList<MovieModel.Result>>()
    val errorLiveData=MutableLiveData<String>()
   suspend fun getMovieRemote(){
       try{
          val data= Retro.getApi().getMovie()
           movieLiveData.postValue(data.results as ArrayList<MovieModel.Result>?)
           MyDataBase.getDataBase().getDao().insertMovie(data)
       }catch (e:Exception){
           errorLiveData.postValue(e.localizedMessage?.toString())
           getMovieLocal()
       }

    }

   private suspend fun getMovieLocal(){
        try {
         val data=   MyDataBase.getDataBase().getDao().getMovie()
            movieLiveData.postValue(data.results as ArrayList<MovieModel.Result>?)
        }catch (e:Exception){
            errorLiveData.postValue(e.localizedMessage?.toString())
        }
    }
}