package hu.bme.aut.bgg_thehotness.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotnessInteractor
import hu.bme.aut.bgg_thehotness.ui.favorites.FavoritesPresenter
import hu.bme.aut.bgg_thehotness.ui.hotness.HotnessPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun hotnessPresenter(
        favoritesInteractor: FavoritesInteractor,
        hotnessInteractor: HotnessInteractor
    ) = HotnessPresenter(favoritesInteractor, hotnessInteractor)

    @Provides
    @Singleton
    fun favoritesPresenter(favoritesInteractor: FavoritesInteractor) =
        FavoritesPresenter(favoritesInteractor)

}