package com.demo.kotlin.room.module

import android.content.Context
import com.demo.kotlin.room.database.WordDao
import com.demo.kotlin.room.database.WordRoomDatabase
import com.demo.kotlin.room.repository.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    fun provideWordDB(
        @ApplicationContext appContext: Context
    ): WordRoomDatabase {
        return WordRoomDatabase.getDatabase(appContext);
    }

    @Provides
    fun provideWordDao(wordRoomDatabase: WordRoomDatabase): WordDao = wordRoomDatabase.wordDao()

    @Provides
    fun provideRepository(wordDao: WordDao) = WordRepository(wordDao)
}