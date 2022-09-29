package com.maxataliyev_01.notesapp.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.maxataliyev_01.notesapp.R
import com.maxataliyev_01.notesapp.ViewModel.NotesViewModel
import com.maxataliyev_01.notesapp.databinding.FragmentHomeBinding
import com.maxataliyev_01.notesapp.ui.Adapter.NotesAdapter


class HomeFragment : Fragment() {
    private val viewModel: NotesViewModel by viewModels()

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        viewModel.getNotes().observe(viewLifecycleOwner) { noteList ->

            binding.recViewAllNotes.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recViewAllNotes.adapter= NotesAdapter(requireContext(),noteList)

        }


        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }


        return binding.root
    }
}