package com.example.swoosh.Controller

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER

class SkillActivity : AppCompatActivity() {
    lateinit var player: Player
    private  lateinit var beginer_level:ToggleButton
    private lateinit var  pro_level:ToggleButton
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
        if(savedInstanceState !=null){
            player= savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        //get that extra activity that we passeed in League Activity
        player= intent.getParcelableExtra(EXTRA_PLAYER)!!

        //if one level selected deselect others
        beginer_level=findViewById(R.id.beginner_Button)
        pro_level=findViewById((R.id.pro_Button))

        beginer_level.setOnClickListener { onBeginerButton() }
        pro_level.setOnClickListener { onProButton() }

        //connect to next xml
        val skillLeague:Button=findViewById(R.id.finish)
        skillLeague.setOnClickListener{
            if(player.skill !=""){
                val skill_league=Intent(this,FinishActivity::class.java)
                //store history of prev xml
                 skill_league.putExtra(EXTRA_PLAYER,player)
                                        //key         value
                startActivity(skill_league)
            }
            else{
                Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun onBeginerButton() {
        pro_level.isChecked=false
        player.skill="Beginer"
    }
    private fun onProButton() {
        beginer_level.isChecked=false
        player.skill="Pro"
    }
}