package com.example.note_using_roomdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.note_using_roomdb.database.AppDatabase
import com.example.note_using_roomdb.databinding.ActivitySecondBinding
import com.example.note_using_roomdb.models.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    private lateinit var appDB : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDB = AppDatabase.initDatabase(this)

        binding.saveNote.setOnClickListener {
            val title = binding.titleET.text.toString()
            val description = binding.descriptionET.text.toString()
            val myobject  = NoteModel(null, title, description)

            GlobalScope.launch{
                appDB.noteDao().insert(myobject)
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}