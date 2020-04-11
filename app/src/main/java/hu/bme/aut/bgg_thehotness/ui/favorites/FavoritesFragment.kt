package hu.bme.aut.bgg_thehotness.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import hu.bme.aut.bgg_thehotness.R
import hu.bme.aut.bgg_thehotness.model.BoardGame

class FavoritesFragment : Fragment(), FavoritesScreen {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)
        val textView: TextView = root.findViewById(R.id.text_favorites)
        textView.text = "Favorites fragment";
        return root
    }

    override fun showFavoriteBoardGames(favoriteGames: List<BoardGame>) {
        TODO("Not yet implemented")
    }

    override fun removeFavoriteGame(gameId: Int) {
        TODO("Not yet implemented")
    }

}