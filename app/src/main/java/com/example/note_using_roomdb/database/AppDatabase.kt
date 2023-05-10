package com.example.note_using_roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.note_using_roomdb.dao.NoteDao
import com.example.note_using_roomdb.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        var INSTANCE: AppDatabase?= null

        fun initDatabase(context: Context): AppDatabase{
            var instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
            INSTANCE=instance
            return instance
        }
    }

}