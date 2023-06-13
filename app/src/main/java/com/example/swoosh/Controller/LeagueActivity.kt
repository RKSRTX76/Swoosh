package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE

class LeagueActivity : BasicActivity() {  // inherit property of BasicActivity class
    var selectedLeague = ""
    private  lateinit var mensLeague:ToggleButton
    private  lateinit var womensLeague:ToggleButton
    private  lateinit var coedLeague:ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val next: Button = findViewById(R.id.Next)
        next.setOnClickListener {
            if(selectedLeague !=""){
                val skillactivity = Intent(this, SkillActivity::class.java)
//                after came back to our activity we lost our data, so we need to pass that data
//                to linked xml(page)
                //put the extra data
                skillactivity.putExtra(EXTRA_LEAGUE,selectedLeague)
                startActivity(skillactivity)


            }
            else{
                Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()
            }

        }
        //initialize variables
        mensLeague=findViewById(R.id.mensLeagueButton)
        womensLeague=findViewById(R.id.womesLeagueButton)
        coedLeague=findViewById(R.id.coedLeagueButton)

        mensLeague.setOnClickListener { onMensClicked() }
        womensLeague.setOnClickListener { onWomensClicked() }
        coedLeague.setOnClickListener { onCoedClicked() }
    }


    private fun onMensClicked() {
        womensLeague.isChecked=false
        coedLeague.isChecked=false
        selectedLeague="Men"
    }
    private fun onWomensClicked() {
        mensLeague.isChecked=false
        coedLeague.isChecked=false
        selectedLeague="Women"
    }
    private fun onCoedClicked() {
        mensLeague.isChecked=false
        womensLeague.isChecked=false
        selectedLeague="Coed"
    }
}