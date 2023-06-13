package com.example.swoosh.Controller

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_SKILL

class SkillActivity : AppCompatActivity() {
    var league=""
    var selectedLevel=""
    private  lateinit var beginer_level:ToggleButton
    private lateinit var  pro_level:ToggleButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        //get that extra activity that we passeed in League Activity
        league= intent.getStringExtra(EXTRA_LEAGUE).toString()
        println(league)

        //if one level selected deselect others
        beginer_level=findViewById(R.id.beginner_Button)
        pro_level=findViewById((R.id.pro_Button))

        beginer_level.setOnClickListener { onBeginerButton() }
        pro_level.setOnClickListener { onProButton() }

        //connect to next xml
        val skillLeague:Button=findViewById(R.id.finish)
        skillLeague.setOnClickListener{
            if(selectedLevel !=""){
                val skill_league=Intent(this,FinishActivity::class.java)
                //store history of prev xml
                 skill_league.putExtra(EXTRA_LEAGUE,league)
                skill_league.putExtra(EXTRA_SKILL,selectedLevel)
                startActivity(skill_league)
            }
            else{
                Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun onBeginerButton() {
        pro_level.isChecked=false
        selectedLevel="Beginer"
    }
    private fun onProButton() {
        beginer_level.isChecked=false
        selectedLevel="Pro"
    }
}