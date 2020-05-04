package hu.bme.aut.bgg_thehotness.ui.hotness

import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.favorites.GameAddedEvent
import hu.bme.aut.bgg_thehotness.interactor.favorites.GameRemovedEvent
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotGamesReceivedEvent
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotnessInteractor
import hu.bme.aut.bgg_thehotness.model.BoardGame
import hu.bme.aut.bgg_thehotness.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class HotnessPresenter @Inject constructor(
    private val favoritesInteractor: FavoritesInteractor,
    private val hotnessInteractor: HotnessInteractor,
    private val executor: Executor
) : Presenter<HotnessScreen>() {

    override fun attachScreen(screen: HotnessScreen) {
        super.attachScreen(screen)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen() {
        super.detachScreen()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    fun refreshHotGames() {
        executor.execute {
            hotnessInteractor.getHotBoardGames()
        }
    }

    fun addToFavorites(game: BoardGame) {
        executor.execute {
            favoritesInteractor.addToFavorites(game)
        }
    }

    fun removeFromFavorites(gameId: Int) {
        executor.execute {
            favoritesInteractor.removeFromFavorites(gameId)
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHotGamesReceived(event: HotGamesReceivedEvent) {
        event.throwable?.printStackTrace()
        screen?.showHotBoardGames(event.games ?: listOf())
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGameAddedToFavorites(event: GameAddedEvent){
        screen?.updateIsFavorite(event.game.gameId, true)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGameRemovedFromFavorites(event: GameRemovedEvent){
        screen?.updateIsFavorite(event.gameId, false)
    }

}