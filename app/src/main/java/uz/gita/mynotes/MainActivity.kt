package uz.gita.mynotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import uz.gita.mynotes.database.NoteDataBase
import uz.gita.mynotes.databinding.ActivityMainBinding
import uz.gita.mynotes.repository.NoteRepository
import uz.gita.mynotes.viewmodel.NoteViewModel
import uz.gita.mynotes.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDataBase(this))

        val viewModelProviderFactory = NoteViewModelProviderFactory(application, noteRepository)

        noteViewModel =
            ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}