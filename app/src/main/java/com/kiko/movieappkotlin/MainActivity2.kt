package com.kiko.movieappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kiko.movieappkotlin.Test.Tea
import javax.inject.Inject


class MainActivity2 : AppCompatActivity() {
@Inject
lateinit var tea: Tea
    @Inject
    lateinit var tea2: Tea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val appComponent=App().getAppComponent()
        val component=appComponent.getTeaComponentBuilder().milk(5).sugar(4)
            .type("kamel").build().inject(this@MainActivity2)
        Log.d("here", " $tea \n $tea2 ${tea.farm}  ${tea2.farm}" +
                "\n ${tea.water} ${tea2.water}")


    }


}
