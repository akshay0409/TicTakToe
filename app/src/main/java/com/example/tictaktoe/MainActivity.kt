package com.example.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tictaktoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var PLAYER=true
    var TURN_COUNT=0

    var boardStatus=Array(3){IntArray(3)}

    lateinit var board:Array<Array<Button>>

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        board=arrayOf(
                arrayOf(binding.button1,binding.button2,binding.button3),
                arrayOf(binding.button4,binding.button5,binding.button6),
                arrayOf(binding.button7,binding.button8,binding.button9)
        )
        for(i in board){
            for(button in i){
                button.setOnClickListener(this)

            }
        }
        initializeBoardStatus()

        //reset button

        binding.button10.setOnClickListener{
                PLAYER=true
                TURN_COUNT=0
            initializeBoardStatus()
        }
    }

    private fun initializeBoardStatus() {
        for(i in 0..2){
            for(j in 0..2){
                boardStatus[0][0]=-1
                board[0][0].isEnabled = true
                board[0][0].text=""
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1->{
                updateValue(row=0,col=0,player=PLAYER)
            }
            R.id.button2->{
                updateValue(row=0,col=1,player=PLAYER)
            }
            R.id.button3->{
                updateValue(row=0,col=2,player=PLAYER)
            }
            R.id.button4->{
                updateValue(row=1,col=0,player=PLAYER)
            }
            R.id.button5->{
                updateValue(row=1,col=1,player=PLAYER)
            }
            R.id.button6->{
                updateValue(row=1,col=2,player=PLAYER)
            }
            R.id.button7->{
                updateValue(row=2,col=0,player=PLAYER)
            }
            R.id.button8->{
                updateValue(row=2,col=1,player=PLAYER)
            }
            R.id.button9->{
                updateValue(row=2,col=2,player=PLAYER)
            }
        }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text =if(player) "X" else "O"
        val value=if(player) 1 else 0

        board[row][col].apply{
            isEnabled = false
            setText(text)
        }
        boardStatus[row][col]=value
    }
}