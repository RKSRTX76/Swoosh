package com.example.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER


class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        //get the transfered data
         val player=intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        val search_League_Text:TextView=findViewById(R.id.searchLeagueText)
        if (player != null) {
            search_League_Text.text="Looking for ${player.league} ${player.skill} league near you "
        }
    }
}