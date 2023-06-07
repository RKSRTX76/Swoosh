package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getstarted:Button=findViewById(R.id.get_started)
        getstarted.setOnClickListener {
            val leagueIntent= Intent(this,LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}