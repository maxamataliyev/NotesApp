package com.maxataliyev_01.notesapp.ui.Fragments


import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.maxataliyev_01.notesapp.Model.Notes
import com.maxataliyev_01.notesapp.R
import com.maxataliyev_01.notesapp.ViewModel.NotesViewModel
import com.maxataliyev_01.notesapp.databinding.FragmentCreateNoteBinding
import java.util.*


class CreateNotesFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private var priority:String="1"
    private val viewModel:NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCreateNoteBinding.inflate(layoutInflater,container,false)

        binding.pGreen.setOnClickListener {
            priority="3"
            binding.pGreen.setImageResource(R.drawable.ic_done)
            binding.pYellow.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.pRed.setOnClickListener {
            priority="1"
            binding.pRed.setImageResource(R.drawable.ic_done)
            binding.pYellow.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.pYellow.setOnClickListener {
            priority="2"
            binding.pYellow.setImageResource(R.drawable.ic_done)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }


        return binding.root
    }


     private fun createNotes(it: View?) {
        val title=binding.editTitle.text.toString()
        val subtitle=binding.editSubTitle.text.toString()
        val notes=binding.editNotes.text.toString()
        val date= Date()
        val notesDate:CharSequence= DateFormat.format("MMMM d,yyyy",date.time)

        val data=Notes(null,
            title=title,
            subtitle=subtitle,
            notes=notes,
            date=notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)
         Toast.makeText(activity, "Notes Created Successfully", Toast.LENGTH_SHORT).show()
         Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }
}