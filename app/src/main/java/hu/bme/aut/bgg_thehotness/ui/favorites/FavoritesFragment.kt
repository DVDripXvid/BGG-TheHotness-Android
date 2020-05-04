package hu.bme.aut.bgg_thehotness.ui.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.bgg_thehotness.R
import hu.bme.aut.bgg_thehotness.injector
import hu.bme.aut.bgg_thehotness.model.BoardGame
import hu.bme.aut.bgg_thehotness.ui.ClickListener
import kotlinx.android.synthetic.main.fragment_favorites.*
import javax.inject.Inject

class FavoritesFragment : Fragment(), FavoritesScreen, ClickListener<BoardGame> {

    private val displayedGames: MutableList<BoardGame> = mutableListOf()
    private var favoritesAdapter: FavoritesAdapter? = null

    @Inject
    lateinit var presenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewFavoriteGames.layoutManager = llm

        favoritesAdapter = FavoritesAdapter(context!!, displayedGames, this)
        recyclerViewFavoriteGames.adapter = favoritesAdapter

        swipeRefreshLayoutFavoriteGames.setOnRefreshListener {
            presenter.refreshFavorites()
        }

        presenter.refreshFavorites()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        injector.inject(this)
        presenter.attachScreen(this)
    }

    override fun onDestroyView() {
        presenter.detachScreen()
        super.onDestroyView()
    }

    override fun onClick(item: BoardGame) {
        presenter.removeFromFavorites(item.gameId)
    }

    override fun showFavoriteBoardGames(favoriteGames: List<BoardGame>) {
        swipeRefreshLayoutFavoriteGames.isRefreshing = false
        displayedGames.clear()
        displayedGames.addAll(favoriteGames)
        favoritesAdapter?.notifyDataSetChanged()
    }

    override fun removeFavoriteGame(gameId: Int) {
        val game = displayedGames.find { it.gameId == gameId }
        val index = displayedGames.indexOf(game)
        displayedGames.removeAt(index)
        favoritesAdapter?.notifyItemRemoved(index)
    }

}