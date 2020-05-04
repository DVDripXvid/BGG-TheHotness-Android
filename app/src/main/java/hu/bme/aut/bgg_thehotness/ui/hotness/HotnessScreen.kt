package hu.bme.aut.bgg_thehotness.ui.hotness

import hu.bme.aut.bgg_thehotness.model.BoardGame

interface HotnessScreen {

    fun showHotBoardGames(hotGames: List<BoardGame>)

    fun updateIsFavorite(gameId: Int, isFavorite: Boolean)
}