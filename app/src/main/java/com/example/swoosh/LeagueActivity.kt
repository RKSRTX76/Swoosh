package com.example.swoosh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LeagueActivity : BasicActivity() {  // inherit property of BasicActivity class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val next:Button=findViewById(R.id.Next)
        next.setOnClickListener {
            val skillactivity= Intent(this,SkillActivity::class.java)
            startActivity(skillactivity)
        }
    }
}