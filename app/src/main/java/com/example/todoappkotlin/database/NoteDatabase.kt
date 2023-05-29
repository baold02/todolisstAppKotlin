package com.example.todoappkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoappkotlin.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNodeDao():NoteDao

    companion object{
        @Volatile
        private var instance:NoteDatabase?=null

        fun getInstance(context: Context):NoteDatabase{
            if(instance == null){
                instance == Room.databaseBuilder(context,NoteDatabase::class.java,"NoteDatabase").build()
            }
            return instance!!
        }
    }
}