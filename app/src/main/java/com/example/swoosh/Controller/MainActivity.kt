package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.swoosh.R

class MainActivity : BasicActivity() {  // inherit property of BasicActivity class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getstarted:Button=findViewById(R.id.get_started)
        getstarted.setOnClickListener {
            val leagueIntent= Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}