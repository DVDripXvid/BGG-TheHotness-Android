package hu.bme.aut.bgg_thehotness

import dagger.Component
import hu.bme.aut.bgg_thehotness.interactor.InteractorModule
import hu.bme.aut.bgg_thehotness.ui.UIModule
import hu.bme.aut.bgg_thehotness.ui.favorites.FavoritesFragment
import hu.bme.aut.bgg_thehotness.ui.hotness.HotnessFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface BGGTheHotnessComponent {

    fun inject(hotnessFragment: HotnessFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    
}