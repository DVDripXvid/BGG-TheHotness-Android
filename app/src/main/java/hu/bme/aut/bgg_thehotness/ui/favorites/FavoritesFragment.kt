package hu.bme.aut.bgg_thehotness.ui.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import hu.bme.aut.bgg_thehotness.R
import hu.bme.aut.bgg_thehotness.injector
import hu.bme.aut.bgg_thehotness.model.BoardGame
import javax.inject.Inject

class FavoritesFragment : Fragment(), FavoritesScreen {

    @Inject
    lateinit var presenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)
        val textView: TextView = root.findViewById(R.id.text_favorites)
        textView.text = "Favorites fragment"
        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        injector.inject(this)
        presenter.attachScreen(this)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachScreen()
    }

    override fun showFavoriteBoardGames(favoriteGames: List<BoardGame>) {
        TODO("Not yet implemented")
    }

    override fun removeFavoriteGame(gameId: Int) {
        TODO("Not yet implemented")
    }

}