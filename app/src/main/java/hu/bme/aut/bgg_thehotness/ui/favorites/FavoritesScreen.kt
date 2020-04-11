package hu.bme.aut.bgg_thehotness.ui.favorites

import hu.bme.aut.bgg_thehotness.model.BoardGame

interface FavoritesScreen {
    fun showFavoriteBoardGames(favoriteGames: List<BoardGame>)

    fun removeFavoriteGame(gameId: Int)
}