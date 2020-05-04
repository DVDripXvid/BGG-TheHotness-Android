package hu.bme.aut.bgg_thehotness.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideBGGApi(): BGGApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bgg-json.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(BGGApi::class.java)
    }

}