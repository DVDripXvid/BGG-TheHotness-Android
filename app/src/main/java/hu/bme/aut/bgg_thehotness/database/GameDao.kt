package hu.bme.aut.bgg_thehotness.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    fun getAll(): List<GameEntity>

    @Insert
    fun insertAll(vararg games: GameEntity)

    @Query("SELECT * FROM GameEntity WHERE gameId = :gameId LIMIT 1")
    fun findById(gameId: Int): GameEntity

    @Delete
    fun delete(game: GameEntity)

}