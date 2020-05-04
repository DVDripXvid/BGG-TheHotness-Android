package hu.bme.aut.bgg_thehotness.ui.hotness

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
import kotlinx.android.synthetic.main.fragment_hotness.*
import javax.inject.Inject

class HotnessFragment : Fragment(), HotnessScreen, ClickListener<BoardGame> {

    private val displayedGames: MutableList<BoardGame> = mutableListOf()
    private var hotnessAdapter: HotnessAdapter? = null

    @Inject
    lateinit var presenter: HotnessPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotness, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewHotGames.layoutManager = llm

        hotnessAdapter = HotnessAdapter(context!!, displayedGames, this)
        recyclerViewHotGames.adapter = hotnessAdapter

        swipeRefreshLayoutHotGames.setOnRefreshListener {
            presenter.refreshHotGames()
        }

        presenter.refreshHotGames()
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

    override fun showHotBoardGames(hotGames: List<BoardGame>) {
        swipeRefreshLayoutHotGames.isRefreshing = false
        displayedGames.clear()
        displayedGames.addAll(hotGames)
        hotnessAdapter?.notifyDataSetChanged()
    }

    override fun updateIsFavorite(gameId: Int, isFavorite: Boolean) {
        val updatedGame = displayedGames.find { it.gameId == gameId }
        updatedGame?.let {
            it.isFavorite = isFavorite
            hotnessAdapter?.notifyItemChanged(displayedGames.indexOf(it))
        }
    }

    override fun onClick(item: BoardGame) {
        if (item.isFavorite == true) {
            presenter.removeFromFavorites(item.gameId)
        } else {
            presenter.addToFavorites(item)
        }
    }

}