package com.example.swoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LeagueActivity : BasicActivity() {  // inherit property of BasicActivity class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

    }
}