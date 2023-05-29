package com.example.todoappkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Update
import com.example.todoappkotlin.models.Note
import com.example.todoappkotlin.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): ViewModel() {
    private val noteRepository:NoteRepository = NoteRepository(application)

    fun insertNode(note: Note) =   viewModelScope.launch{
        noteRepository.insertNote(note)
    }


    fun updateNode(note: Note) =   viewModelScope.launch{
        noteRepository.updateNote(note)
    }


    fun deleteNode(note: Note) =   viewModelScope.launch{
        noteRepository.deleteNote(note)
    }


    fun getAllNote():LiveData<List<Note>> = noteRepository.getAllNote()

    class NoteViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if(modelClass.isAssignableFrom(NoteViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(application)  as T
                }
                throw java.lang.IllegalArgumentException("Unable contruct viewModel")
        }

    }

}