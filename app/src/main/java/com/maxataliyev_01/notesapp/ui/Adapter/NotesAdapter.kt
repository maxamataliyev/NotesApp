package com.maxataliyev_01.notesapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxataliyev_01.notesapp.Model.Notes
import com.maxataliyev_01.notesapp.R
import com.maxataliyev_01.notesapp.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context,val noteList: List<Notes>) :RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
    class notesViewHolder(val binding: ItemNotesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data=noteList[position]
        holder.binding.notesTitle.text=data.title
        holder.binding.notesSubtitle.text=data.subtitle
        holder.binding.notesDate.text=data.date
        when(data.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
        }

    }

    override fun getItemCount()=noteList.size
}