package hu.bme.aut.bgg_thehotness.interactor

import dagger.Module
import dagger.Provides
import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotnessInteractor
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun hotnessInteractor() = HotnessInteractor()

    @Provides
    @Singleton
    fun favoritesInteractor() = FavoritesInteractor()

}