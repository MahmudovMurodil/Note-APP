package uz.gita.mynotes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.gita.mynotes.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Select * from notes order by id desc")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("Select * from notes where noteTitle Like:query or noteBody Like:query")
    fun searchNotes(query: String?): LiveData<List<Note>>
}