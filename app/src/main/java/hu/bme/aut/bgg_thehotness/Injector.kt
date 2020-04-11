package hu.bme.aut.bgg_thehotness

import androidx.fragment.app.Fragment

val Fragment.injector: BGGTheHotnessComponent
    get() {
        return (this.context!!.applicationContext as BGGTheHotnessApplication).injector
    }