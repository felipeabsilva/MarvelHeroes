package com.felipesilva.marvelheroes.adapter.viewHolder

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipesilva.marvelheroes.data.model.ComicsDetails
import kotlinx.android.synthetic.main.card_comic.view.*

class ComicsCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.image_comic
    private val titleView = itemView.text_comic_title

    fun bind(comicsDetails: ComicsDetails) {
        bindImage(imageView, comicsDetails.thumbnail.path, comicsDetails.thumbnail.extension)
        titleView.text = comicsDetails.title
    }

    private fun bindImage(imageView: ImageView, imagePath: String, imageExtension: String) {
        imagePath.let {
            val imageUrl = "$imagePath.$imageExtension"
            Log.d("123felipe", imageUrl)
            Glide.with(imageView.context)
                .load(imageUrl)
                .override(120,185)
                .into(imageView)
        }
    }
}