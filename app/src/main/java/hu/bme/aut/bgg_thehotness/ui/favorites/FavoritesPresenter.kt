package hu.bme.aut.bgg_thehotness.ui.favorites

import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoriteGamesReceivedEvent
import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.favorites.GameAddedEvent
import hu.bme.aut.bgg_thehotness.interactor.favorites.GameRemovedEvent
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotGamesReceivedEvent
import hu.bme.aut.bgg_thehotness.ui.Presenter
import hu.bme.aut.bgg_thehotness.ui.hotness.HotnessScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(
    private val favoritesInteractor: FavoritesInteractor,
    private val executor: Executor
) :
    Presenter<FavoritesScreen>() {

    override fun attachScreen(screen: FavoritesScreen) {
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

    fun refreshFavorites() {
        executor.execute { favoritesInteractor.getFavoriteBoardGames() }
    }

    fun removeFromFavorites(gameId: Int) {
        executor.execute { favoritesInteractor.removeFromFavorites(gameId) }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHotGamesReceived(event: FavoriteGamesReceivedEvent) {
        screen?.showFavoriteBoardGames(event.games)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGameRemovedFromFavorites(event: GameRemovedEvent) {
        screen?.removeFavoriteGame(event.gameId)
    }

}