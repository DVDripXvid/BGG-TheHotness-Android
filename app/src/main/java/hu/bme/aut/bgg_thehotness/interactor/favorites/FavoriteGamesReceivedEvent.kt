package hu.bme.aut.bgg_thehotness.interactor.favorites

import hu.bme.aut.bgg_thehotness.model.BoardGame

data class FavoriteGamesReceivedEvent(var games: List<BoardGame>)