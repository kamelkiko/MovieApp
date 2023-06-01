package com.kiko.movieappkotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kiko.movieappkotlin.Adapters.RecAdapter
import com.kiko.movieappkotlin.Data.HomeViewModel
import com.kiko.movieappkotlin.databinding.ActivityMainBinding
import com.kiko.movieappkotlin.modelclass.MovieModel


private var _binding:ActivityMainBinding?=null
private val binding get() = _binding!!
private lateinit var homeViewModel: HomeViewModel
private lateinit var list:ArrayList<MovieModel.Result>
private val adapter by lazy{RecAdapter()}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       _binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(_binding?.root)
        binding.load.visibility=View.VISIBLE
homeViewModel=ViewModelProvider(this@MainActivity)[HomeViewModel::class.java]
getMovie()

        getObservers()

    }

private fun getMovie(){
    homeViewModel.getMovie()
}
private fun getObservers(){
    homeViewModel.movieLiveData.observe(this@MainActivity){
        binding.load.visibility=View.GONE
        list=it
       adapter.setList(list)
        binding.rec.adapter= adapter
    }
    homeViewModel.errorLiveData.observe(this@MainActivity){
        showToast(it.toString())
    }
}
    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }
}




