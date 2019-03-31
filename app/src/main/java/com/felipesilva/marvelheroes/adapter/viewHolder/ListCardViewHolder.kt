package com.felipesilva.marvelheroes.adapter.viewHolder

import android.content.Intent
import android.util.Log.d
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipesilva.marvelheroes.data.model.CharactersData
import com.felipesilva.marvelheroes.ui.details.DetailsActivity
import com.felipesilva.marvelheroes.utilities.formatDate
import kotlinx.android.synthetic.main.card_list.view.*

class ListCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val cardView = itemView.card_list
    private val imageView = itemView.image_card_character
    private val nameView = itemView.text_card_name
    private val modifiedView = itemView.text_card_modified
    private val descriptionView = itemView.text_card_description
    private lateinit var imageUrl: String

    fun bind(charactersData: CharactersData) {
        nameView.text = charactersData.name
        descriptionView.text = charactersData.description
        modifiedView.text = "Last Modify: ${charactersData.lastModify.formatDate()}"
        imageUrl = "${charactersData.thumbnail.path}.${charactersData.thumbnail.extension}"

        bindImage(imageView)

        bindCardDetails(cardView, charactersData)
    }

    private fun bindImage(imageView: ImageView) {
        imageUrl.let {
            d("123felipe", it)
            Glide.with(imageView.context)
                .load(it)
                .override(120,120)
                .into(imageView)
        }
    }

    private fun bindCardDetails(cardView: CardView, charactersData: CharactersData) {
        cardView.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)

            intent.apply {
                putExtra("id", charactersData.id)
                putExtra("image", imageUrl)
                putExtra("name", charactersData.name)
                putExtra("lastMofidy", "Last Modify: ${charactersData.lastModify.formatDate()}")
                putExtra("description", charactersData.description)
            }

            it.context.startActivity(intent)
        }
    }
}