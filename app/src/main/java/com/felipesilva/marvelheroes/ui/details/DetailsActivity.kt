package com.felipesilva.marvelheroes.ui.details

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.felipesilva.marvelheroes.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.card_details)
        initializeUI()
    }

    private fun initializeUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}