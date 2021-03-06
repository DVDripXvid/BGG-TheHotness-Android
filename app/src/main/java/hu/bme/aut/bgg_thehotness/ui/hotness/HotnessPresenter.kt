package hu.bme.aut.bgg_thehotness.ui.hotness

import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotnessInteractor
import hu.bme.aut.bgg_thehotness.model.BoardGameWithIsFavorite
import hu.bme.aut.bgg_thehotness.ui.Presenter
import javax.inject.Inject

class HotnessPresenter @Inject constructor(
    private val favoritesInteractor: FavoritesInteractor,
    private val hotnessInteractor: HotnessInteractor
) : Presenter<HotnessScreen>() {

    fun refreshHotGames() {
        TODO("Not yet implemented")
    }

    fun addToFavorites(game: BoardGameWithIsFavorite) {
        TODO("Not yet implemented")
    }

    fun removeFromFavorites(gameId: Int) {
        TODO("Not yet implemented")
    }

}