package com.demo.kotlin.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): WordRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, WordRoomDatabase::class.java, "word_database"
                ).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    /* private class WordDatabaseCallback(
         private val scope: CoroutineScope
     ) : RoomDatabase.Callback() {

         override fun onCreate(db: SupportSQLiteDatabase) {
             super.onCreate(db)
             INSTANCE?.let { database ->
                 scope.launch {
                     populateDatabase(database.wordDao())
                 }
             }
         }

         suspend fun populateDatabase(wordDao: WordDao) {
             // Delete all content here.
             wordDao.deleteAll()

             // Add sample words.
             var word = Word("Hello")
             wordDao.insert(word)
             word = Word("World!")
             wordDao.insert(word)
             word = Word("Hope")
             wordDao.insert(word)
             word = Word("Everything")
             wordDao.insert(word)
             word = Word("Fine!")
             wordDao.insert(word)
         }
     }*/
}