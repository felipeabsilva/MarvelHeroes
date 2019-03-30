package com.felipesilva.marvelheroes.adapter.viewHolder

import android.util.Log.d
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipesilva.marvelheroes.data.model.CharactersData
import com.felipesilva.marvelheroes.utilities.formatDate
import kotlinx.android.synthetic.main.card_list.view.*

class ListCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val cardView = itemView.card_list
    val imageView = itemView.image_card_character
    val nameview = itemView.text_card_name
    val modifiedView = itemView.text_card_modified
    val descriptionView = itemView.text_card_description

    fun bind(charactersData: CharactersData) {
        nameview.text = charactersData.name
        descriptionView.text = charactersData.description
        modifiedView.text = "Last Modify: ${charactersData.lastModify.formatDate()}"
        bindImage(imageView,
            charactersData.thumbnail.path,
            charactersData.thumbnail.extension)
    }

    private fun bindImage(imageView: ImageView, imagePath: String, imageExtension: String) {
        imagePath.let {
            val imageUrl = "$imagePath.$imageExtension"
            d("123felipe", imageUrl)
            Glide.with(imageView.context)
                .load(imageUrl)
                .override(120,120)
                .into(imageView)
        }
    }

    private fun bindCardDetails(cardView: CardView) {
        cardView.setOnClickListener {

        }
    }
}