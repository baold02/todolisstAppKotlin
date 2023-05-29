package com.example.todoappkotlin.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todoappkotlin.database.NoteDao
import com.example.todoappkotlin.database.NoteDatabase
import com.example.todoappkotlin.models.Note

class NoteRepository(application: Application) {
    private val noteDao:NoteDao
    init {
           val noteDatabase:NoteDatabase = NoteDatabase.getInstance(application)
        noteDao= noteDatabase.getNodeDao()
    }

    suspend fun  insertNote(note:Note) = noteDao.insertNote(note)
    suspend fun  updateNote(note:Note) = noteDao.updateNote(note)
    suspend fun  deleteNote(note:Note) = noteDao.deleteNote(note)

    fun getAllNote():LiveData<List<Note>> = noteDao.getAllNote()

}