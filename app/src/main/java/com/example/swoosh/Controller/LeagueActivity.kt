package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER

class LeagueActivity : BasicActivity() {  // inherit property of BasicActivity class
//    var selectedLeague = ""
    var player= Player("","")
    private  lateinit var mensLeague:ToggleButton
    private  lateinit var womensLeague:ToggleButton
    private  lateinit var coedLeague:ToggleButton
//   this part is for to store data at landscapemode
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    outState?.putParcelable(EXTRA_PLAYER,player)
    }
//-------------------------------
    //case handle where if we rotate our screen if any previously saved data
//    is present then only pass
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            if (savedInstanceState != null){
                player= savedInstanceState.getParcelable(EXTRA_PLAYER)!!
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val next: Button = findViewById(R.id.Next)
        next.setOnClickListener {
            if(player.league !=""){
                val skillactivity = Intent(this, SkillActivity::class.java)
//                after came back to our activity we lost our data, so we need to pass that data
//                to linked xml(page)
                //put the extra data
//                skillactivity.putExtra(EXTRA_LEAGUE,selectedLeague)
                //parceble means put/wrap up everything inside a class
                //here we are wra[[ing our data inside a class called "Player"
                skillactivity.putExtra(EXTRA_PLAYER,player)
                                       //key         value
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
//        selectedLeague="Men"
        player.league="Men"
    }
    private fun onWomensClicked() {
        mensLeague.isChecked=false
        coedLeague.isChecked=false
//        selectedLeague="Women"
        player.league="Women"
    }
    private fun onCoedClicked() {
        mensLeague.isChecked=false
        womensLeague.isChecked=false
//        selectedLeague="Coed"
        player.league="Coed"
    }
}