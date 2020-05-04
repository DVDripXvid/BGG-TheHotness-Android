package hu.bme.aut.bgg_thehotness.ui

import org.greenrobot.eventbus.EventBus

abstract class Presenter<S> {
    protected var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        this.screen = null
    }
}