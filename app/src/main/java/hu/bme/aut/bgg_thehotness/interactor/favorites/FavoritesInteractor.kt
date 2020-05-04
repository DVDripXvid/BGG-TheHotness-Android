package hu.bme.aut.bgg_thehotness.interactor.favorites

import hu.bme.aut.bgg_thehotness.database.AppDatabase
import hu.bme.aut.bgg_thehotness.database.GameEntity
import hu.bme.aut.bgg_thehotness.model.BoardGame
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class FavoritesInteractor @Inject constructor(private val database: AppDatabase) {

    private val gameDao = database.gameDao();

    fun getFavoriteBoardGames() {
        val games = gameDao.getAll()
        EventBus.getDefault().post(FavoriteGamesReceivedEvent(games = games.map { it.toModel() }))
    }

    fun addToFavorites(game: BoardGame) {
        gameDao.insertAll(GameEntity.fromModel(game))
        EventBus.getDefault().post(GameAddedEvent(game))
    }

    fun removeFromFavorites(gameId: Int) {
        val game = gameDao.findById(gameId)
        gameDao.delete(game)
        EventBus.getDefault().post(GameRemovedEvent(game.gameId))
    }

}