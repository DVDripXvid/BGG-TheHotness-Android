package hu.bme.aut.bgg_thehotness

import android.app.Application
import hu.bme.aut.bgg_thehotness.ui.UIModule

class BGGTheHotnessApplication : Application() {

    lateinit var injector: BGGTheHotnessComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerBGGTheHotnessComponent.builder().uIModule(UIModule(this)).build()
    }
}