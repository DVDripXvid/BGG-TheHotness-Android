package hu.bme.aut.bgg_thehotness.interactor.hotness

import hu.bme.aut.bgg_thehotness.model.BoardGame

data class HotGamesReceivedEvent(var games: List<BoardGame>? = null, var throwable: Throwable? = null)