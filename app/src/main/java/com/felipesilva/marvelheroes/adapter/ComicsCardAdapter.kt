package com.felipesilva.marvelheroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.adapter.viewHolder.ComicsCardViewHolder
import com.felipesilva.marvelheroes.data.model.ComicsDetails

class ComicsCardAdapter(private val comics: LiveData<List<ComicsDetails>>) : RecyclerView.Adapter<ComicsCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_comic, parent, false)
        return ComicsCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        comics.value.apply {
            return if (this == null || this.isEmpty())
                0
            else
                this.size
        }
    }

    override fun onBindViewHolder(holder: ComicsCardViewHolder, position: Int) {
        comics.value?.let {
            val comic = it[position]
            holder.bind(comic)
        }
    }

}