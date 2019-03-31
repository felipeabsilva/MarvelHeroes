package com.felipesilva.marvelheroes.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.felipesilva.marvelheroes.R
import com.felipesilva.marvelheroes.data.repository.Repository
import com.felipesilva.marvelheroes.ui.list.ListActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class SplashScreenActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val repository : Repository by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        repository.makeCallListHeroes()

        val handler = Handler()
        handler.postDelayed(object: Runnable {
            override fun run() {
                val intent = Intent(this@SplashScreenActivity, ListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}