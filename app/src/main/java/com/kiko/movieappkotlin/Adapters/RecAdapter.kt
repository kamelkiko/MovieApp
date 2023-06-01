package com.kiko.movieappkotlin.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiko.movieappkotlin.Constant.Const
import com.kiko.movieappkotlin.databinding.ItemMovieBinding
import com.kiko.movieappkotlin.modelclass.MovieModel

class RecAdapter : RecyclerView.Adapter<RecAdapter.Holder>() {
  private lateinit var list:ArrayList<MovieModel.Result>

  fun setList(list:ArrayList<MovieModel.Result>){
      this.list=list
  }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding=ItemMovieBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.binding.apply {
        textMovie.text=list[position].original_title
            textDateMovie.text=list[position].release_date
        Glide.with(holder.itemView.context).load(Const.IMAGE_URL+list[position].backdrop_path)
            .into(posterMoive)
        }
    }

    override fun getItemCount(): Int {
        return if (list==null) 0 else list.size
    }



    inner class Holder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}