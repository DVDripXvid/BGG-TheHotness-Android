package hu.bme.aut.bgg_thehotness.ui.hotness

import hu.bme.aut.bgg_thehotness.model.BoardGameWithIsFavorite

interface HotnessScreen {

    fun showHotBoardGames(hotGames: List<BoardGameWithIsFavorite>)

    fun updateBoardGame(game: BoardGameWithIsFavorite)
}