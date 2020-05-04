package hu.bme.aut.bgg_thehotness.interactor

import dagger.Module
import dagger.Provides
import hu.bme.aut.bgg_thehotness.database.AppDatabase
import hu.bme.aut.bgg_thehotness.interactor.favorites.FavoritesInteractor
import hu.bme.aut.bgg_thehotness.interactor.hotness.HotnessInteractor
import hu.bme.aut.bgg_thehotness.network.BGGApi
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun hotnessInteractor(bggApi: BGGApi, appDatabase: AppDatabase) =
        HotnessInteractor(bggApi, appDatabase)

    @Provides
    @Singleton
    fun favoritesInteractor(database: AppDatabase) = FavoritesInteractor(database)

}