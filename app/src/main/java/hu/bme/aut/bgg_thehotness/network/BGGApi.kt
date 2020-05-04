package hu.bme.aut.bgg_thehotness.network

import hu.bme.aut.bgg_thehotness.model.BoardGame
import retrofit2.Call
import retrofit2.http.GET

interface BGGApi {

    @GET("hot")
    fun getHotGames(): Call<List<BoardGame>>

}