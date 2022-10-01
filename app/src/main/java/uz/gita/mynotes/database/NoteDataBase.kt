package uz.gita.mynotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.mynotes.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private var instance: NoteDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also {
                instance = it
            }
        }

        private fun createDataBase(context: Context) = Room.databaseBuilder(
            context.applicationContext, NoteDataBase::class.java, "note_db"
        ).build()
    }
}