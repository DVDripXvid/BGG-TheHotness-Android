package hu.bme.aut.bgg_thehotness

import android.app.Application
import hu.bme.aut.bgg_thehotness.database.DatabaseModule
import hu.bme.aut.bgg_thehotness.ui.UIModule
import org.greenrobot.eventbus.EventBus




class BGGTheHotnessApplication : Application() {

    lateinit var injector: BGGTheHotnessComponent

    override fun onCreate() {
        super.onCreate()

        injector = DaggerBGGTheHotnessComponent.builder()
            .uIModule(UIModule(this))
            .databaseModule(DatabaseModule(this))
            .build()
    }
}