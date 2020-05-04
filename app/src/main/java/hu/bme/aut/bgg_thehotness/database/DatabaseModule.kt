package hu.bme.aut.bgg_thehotness.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Singleton
    @Provides
    fun roomDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "game.db")
            .build()
    }
}