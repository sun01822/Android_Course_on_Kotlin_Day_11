package com.example.note_using_roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note_using_roomdb.database.AppDatabase
import com.example.note_using_roomdb.databinding.ActivityMainBinding
import com.example.note_using_roomdb.models.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mydb: AppDatabase
    private lateinit var myDataList : ArrayList<NoteModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mydb = AppDatabase.initDatabase(this)
        getLocalData()

        binding.favButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
    private fun getLocalData(){
        myDataList = arrayListOf()
        GlobalScope.launch {
            mydb.noteDao().getAllNotes().forEach{
                singleData -> myDataList.add(singleData)
            }
            initRecyclerView()
        }
    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomAdapter(myDataList)
    }
}