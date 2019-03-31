package com.felipesilva.marvelheroes.ui.details

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.adapter.ComicsCardAdapter
import kotlinx.android.synthetic.main.card_details.*
import kotlinx.android.synthetic.main.card_list.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class DetailsActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val detailsViewModelFactory : DetailsModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_details)
        initializeUI()
    }

    private fun initializeUI() {
        val detailsViewModel = ViewModelProviders.of(this, detailsViewModelFactory)
            .get(DetailsViewModel::class.java)

        recycler_comics.apply {
            layoutManager = GridLayoutManager(this@DetailsActivity, 3)
        }

        val id = intent.getIntExtra("id", 0)
        detailsViewModel.makeCallListComics(id)

        bindElements()

        detailsViewModel.getComics().observe(this, Observer {
            recycler_comics.adapter = ComicsCardAdapter(detailsViewModel.getComics())
        })
    }

    private fun bindElements() {
        val imageView = image_detail_character
        val nameView = text_detail_name
        val modifiedView = text_detail_modified
        val descriptionView = text_detail_description

        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val lastModify = intent.getStringExtra("lastMofidy")

        setupActionBar(name)

        val description = if (intent.getStringExtra("description") != "")
            intent.getStringExtra("description")
        else
            "Description not assigned."

        image?.let {
            Glide.with(imageView.context)
                .load(it)
                .into(imageView)
        }

        nameView.text = name
        modifiedView.text = lastModify
        descriptionView.text = description
    }

    fun setupActionBar(title: String) {
        val actionBar = supportActionBar
        actionBar?.title = title
    }

}