package com.example.note_using_roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.note_using_roomdb.models.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * from note_table")
    fun getAllNotes(): List<NoteModel>

    @Query("SELECT * from note_table WHERE title LIKE:amadertitle LIMIT 5")
    fun getAllNotesByTitle(amadertitle: String): List<NoteModel>

    @Delete
    fun deleteNote(note: NoteModel)

    @Insert
    fun insert(note: NoteModel)
}