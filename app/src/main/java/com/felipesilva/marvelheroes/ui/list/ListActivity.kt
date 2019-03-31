package com.felipesilva.marvelheroes.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.adapter.ListCardAdapter
import com.felipesilva.marvelheroes.data.model.CharactersData
import kotlinx.android.synthetic.main.activity_list.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ListActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val listViewModelFactory : ListViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initializeUI()
    }

    private fun initializeUI() {
        val viewModel = ViewModelProviders.of(this, listViewModelFactory)
            .get(ListViewModel::class.java)

        recycler_list.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
        }

        viewModel.getHeroes().observe(this, Observer {
            recycler_list.adapter = ListCardAdapter(viewModel.getHeroes())
        })
    }
}
