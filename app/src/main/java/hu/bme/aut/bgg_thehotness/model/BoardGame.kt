package hu.bme.aut.bgg_thehotness.model

data class BoardGame(
    var gameId: Int,
    var name: String,
    var rank: Int,
    var yearPublished: Int,
    var thumbnail: Int
)