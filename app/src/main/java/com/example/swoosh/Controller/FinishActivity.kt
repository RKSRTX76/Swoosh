package com.example.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_SKILL

class FinishActivity : AppCompatActivity() {
    var leagues=""
    var skills=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        //get the transfered data
        leagues=intent.getStringExtra(EXTRA_LEAGUE).toString()
        skills=intent.getStringExtra(EXTRA_SKILL).toString()

        searchLeagueText.text="Looking for $leagues $skills league near you "
    }
}