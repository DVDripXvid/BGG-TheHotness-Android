package hu.bme.aut.bgg_thehotness.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.bgg_thehotness.model.BoardGame

@Entity
data class GameEntity(
    @PrimaryKey val gameId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "rank") val rank: Int,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "year_published") val yearPublished: Int
) {
    fun toModel(): BoardGame {
        return BoardGame(gameId, name, rank, yearPublished, thumbnail, true)
    }

    companion object {
        fun fromModel(game: BoardGame): GameEntity {
            return GameEntity(game.gameId, game.name, game.rank, game.thumbnail, game.yearPublished)
        }
    }
}