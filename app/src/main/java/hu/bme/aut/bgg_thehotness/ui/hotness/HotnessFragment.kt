package hu.bme.aut.bgg_thehotness.ui.hotness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import hu.bme.aut.bgg_thehotness.R
import hu.bme.aut.bgg_thehotness.model.BoardGameWithIsFavorite

class HotnessFragment : Fragment(), HotnessScreen {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hotness, container, false)
        val textView: TextView = root.findViewById(R.id.text_hotness)
        textView.text = "The hotness fragment";
        return root
    }

    override fun showHotBoardGames(hotGames: List<BoardGameWithIsFavorite>) {
        TODO("Not yet implemented")
    }

    override fun updateBoardGame(game: BoardGameWithIsFavorite) {
        TODO("Not yet implemented")
    }

}