package com.maxataliyev_01.notesapp.Repository

import androidx.lifecycle.LiveData
import com.maxataliyev_01.notesapp.Dao.NotesDao
import com.maxataliyev_01.notesapp.Model.Notes

class NotesRepository(val dao: NotesDao) {
    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}