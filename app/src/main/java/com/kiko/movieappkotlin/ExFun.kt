package com.kiko.movieappkotlin

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showToast(msg:Any){
    Toast.makeText(this@showToast,msg.toString(),Toast.LENGTH_SHORT).show()
}