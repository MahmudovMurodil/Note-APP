package uz.gita.mynotes.repository

import uz.gita.mynotes.database.NoteDataBase
import uz.gita.mynotes.model.Note

class NoteRepository(private val db: NoteDataBase) {

    suspend fun addNote(note: Note) = db.getNoteDao().addNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()

    fun getSearchResult(query: String?) = db.getNoteDao().searchNotes(query)
}