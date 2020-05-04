package hu.bme.aut.bgg_thehotness.interactor.hotness

import hu.bme.aut.bgg_thehotness.database.AppDatabase
import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.network.BGGApi
import org.greenrobot.eventbus.EventBus
import java.lang.Exception
import javax.inject.Inject

class HotnessInteractor @Inject constructor(
    private val api: BGGApi,
    private val database: AppDatabase
) {

    fun getHotBoardGames() {
        try {
            val result = api.getHotGames().execute()
            if (!result.isSuccessful) {
                throw Exception(result.message())
            }
            val favorites = database.gameDao().getAll()
            val games = result.body()?.map { g ->
                if (favorites.any { f -> f.gameId == g.gameId }) {
                    g.isFavorite = true
                }
                g
            }

            val event = HotGamesReceivedEvent(games)
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            EventBus.getDefault().post(HotGamesReceivedEvent(throwable = e))
        }
    }
}