package com.kiko.movieappkotlin

import android.app.Application
import com.kiko.movieappkotlin.Room.MyDataBase
import com.kiko.movieappkotlin.Test.AppComponent
import com.kiko.movieappkotlin.Test.DaggerAppComponent


private lateinit var appComponent: AppComponent
class App  : Application() {

    override fun onCreate() {
        super.onCreate()
        MyDataBase.initDataBase(this@App)
appComponent=DaggerAppComponent.create()

    }

fun getAppComponent():AppComponent{
    return appComponent
}

}