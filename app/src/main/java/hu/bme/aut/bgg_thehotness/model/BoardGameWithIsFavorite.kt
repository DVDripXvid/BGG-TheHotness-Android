package hu.bme.aut.bgg_thehotness.model

data class BoardGameWithIsFavorite(
    var gameId: Int,
    var name: String,
    var rank: Int,
    var yearPublished: Int,
    var thumbnail: Int,
    var isFavorite: Boolean
)