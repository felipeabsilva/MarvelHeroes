package com.felipesilva.marvelheroes.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.data.CharactersData
import com.felipesilva.marvelheroes.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_list.*
import java.lang.StringBuilder

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideListViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(ListViewModel::class.java)

        viewModel.getHeroes().observe(this, Observer { heroes ->
            val stringBuilder = StringBuilder()
            heroes.forEach{ hero ->
                stringBuilder.append("$hero\n\n")
            }
            text_view.text= stringBuilder.toString()
        })

        button_test.setOnClickListener {
            val character = CharactersData("Felipe", "Yesterday", "Desc")
            val character2 = CharactersData("Felipe2", "Yesterday2", "Desc2")

            viewModel.addCharacter(character)
            viewModel.addCharacter(character2)
        }

    }
}
