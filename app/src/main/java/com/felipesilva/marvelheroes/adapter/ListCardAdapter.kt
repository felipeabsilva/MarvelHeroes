package com.felipesilva.marvelheroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.adapter.viewHolder.ListCardViewHolder
import com.felipesilva.marvelheroes.data.model.CharactersData

class ListCardAdapter(private val heroes: LiveData<List<CharactersData>>) : RecyclerView.Adapter<ListCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list, parent, false)
        return ListCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        heroes.value.apply {
            return if (this == null || this.isEmpty())
                0
            else
                this.size
        }
    }

    override fun onBindViewHolder(holder: ListCardViewHolder, position: Int) {
        heroes.value?.let {
            val character = it[position]
            holder.bind(character)
        }
    }

}