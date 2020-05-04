package hu.bme.aut.bgg_thehotness.ui.hotness

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.bme.aut.bgg_thehotness.R
import hu.bme.aut.bgg_thehotness.model.BoardGame
import hu.bme.aut.bgg_thehotness.ui.ClickListener
import kotlinx.android.synthetic.main.card_hot_game.view.*

class HotnessAdapter constructor(
    private val context: Context,
    private var games: List<BoardGame>,
    private var clickListener: ClickListener<BoardGame>
) : RecyclerView.Adapter<HotnessAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.card_hot_game, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]

        Glide.with(context).load(game.thumbnail).into(holder.ivImage)

        val names = game.name.split(":")
        holder.tvName.text = names[0].trim()
        holder.tvSubtitle.text = if (names.size > 1) names[1].trim() else ""

        holder.tvYearPublished.text = game.yearPublished.toString()

        if (game.isFavorite == true) {
            holder.ibFavorite.setImageResource(android.R.drawable.star_on)
        } else {
            holder.ibFavorite.setImageResource(android.R.drawable.star_off)
        }

        holder.ibFavorite.setOnClickListener { clickListener.onClick(game) }
    }

    override fun getItemCount() = games.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivHotGameImage
        var tvName: TextView = view.tvHotGameName
        var tvSubtitle: TextView = view.tvHotGameSubtitle
        var tvYearPublished: TextView = view.tvHotGameYearPublished
        var ibFavorite: ImageButton = view.bHotGameFavorite
    }
}