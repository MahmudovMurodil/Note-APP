package uz.gita.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.mynotes.model.Note
import uz.gita.mynotes.repository.NoteRepository

class NoteViewModel(
    val app: Application, private val noteRepository: NoteRepository
) : AndroidViewModel(app) {

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun getSearchResult(query: String?) = noteRepository.getSearchResult(query)
}