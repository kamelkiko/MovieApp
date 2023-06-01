package com.kiko.movieappkotlin.Data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiko.movieappkotlin.modelclass.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

class HomeViewModel : ViewModel() {
    var movieLiveData: MutableLiveData<ArrayList<MovieModel.Result>>
    var errorLiveData: MutableLiveData<String>
    private val repo = Repo()

    init {
        movieLiveData = repo.movieLiveData
        errorLiveData = repo.errorLiveData
    }

    fun getMovie() {
            repo.getMovieRemote()
    }
    
}