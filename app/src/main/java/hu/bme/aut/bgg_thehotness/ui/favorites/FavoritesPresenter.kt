package hu.bme.aut.bgg_thehotness.ui.favorites

import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.ui.Presenter
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(private val favoritesInteractor: FavoritesInteractor) :
    Presenter<FavoritesScreen>() {

    fun refreshFavorites() {
        TODO("Not yet implemented")
    }

    fun removeFromFavorites(gameId: Int) {
        TODO("Not yet implemented")
    }

}