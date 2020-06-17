package com.example.tictactoykotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    var winner = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    } // end onCreate()

//    override fun onStop() {
//        super.onStop()
//    }

    fun butSelect(view: View){
        var butChoice = view as Button
        var cell_id = 0
        if((winner!= 1 && winner!=2)){
            when(butChoice.id){
                R.id.btn1->{
                    cell_id = 1
                    Toast.makeText(applicationContext , "btn1 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn2->{
                    cell_id = 2
                    Toast.makeText(applicationContext , "btn2 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn3->{
                    cell_id = 3
                    Toast.makeText(applicationContext , "btn3 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn4->{
                    cell_id = 4
                    Toast.makeText(applicationContext , "btn4 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn5->{
                    cell_id = 5
                    Toast.makeText(applicationContext , "btn5 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn6->{
                    Toast.makeText(applicationContext , "btn6 selected" , Toast.LENGTH_LONG).show()
                    cell_id = 6
                }
                R.id.btn7->{
                    cell_id = 7
                    Toast.makeText(applicationContext , "btn7 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn8->{
                    cell_id = 8
                    Toast.makeText(applicationContext , "btn8 selected" , Toast.LENGTH_LONG).show()
                }
                R.id.btn9->{
                    cell_id = 9
                    Toast.makeText(applicationContext , "btn9 selected" , Toast.LENGTH_LONG).show()
                }
            } // end when
            playGame( cell_id,butChoice )
        }
        else
            return

    } // end butSelect()


    @SuppressLint("ResourceAsColor")
    fun playGame(cell_id:Int, butChoice:Button){
        if(activePlayer == 1){
            butChoice.text = "X"
            butChoice.setBackgroundResource(R.color.lightBlue)
            player1.add(cell_id)
            activePlayer = 2
            if((winner!= 1 && winner!=2)){
                autoPlay()
            }
            else
                return
        }
        else{
            butChoice.text = "O"
            butChoice.setBackgroundResource(R.color.darkGreen)
            player2.add(cell_id)
            activePlayer = 1
        }
        checkWinner()
        butChoice.isEnabled = false
      //  onStop()

    } // end playGame()

    fun checkWinner(){

        if((player1.contains(1) && player1.contains(2) && player1.contains(3))||
            (player1.contains(4) && player1.contains(5) && player1.contains(6))||
            (player1.contains(7) && player1.contains(8) && player1.contains(9))||
            (player1.contains(1) && player1.contains(4) && player1.contains(7))||
            (player1.contains(2) && player1.contains(5) && player1.contains(8))||
            (player1.contains(3) && player1.contains(6) && player1.contains(9))){
            winner = 1
        }
        if((player2.contains(1) && player2.contains(2) && player2.contains(3))||
            (player2.contains(4) && player2.contains(5) && player2.contains(6))||
            (player2.contains(7) && player2.contains(8) && player2.contains(9))||
            (player2.contains(1) && player2.contains(4) && player2.contains(7))||
            (player2.contains(2) && player2.contains(5) && player2.contains(8))||
            (player2.contains(3) && player2.contains(6) && player2.contains(9))){
            winner = 2
        }
        if(winner != -1 ){
            if(winner ==1)
                Toast.makeText(applicationContext, "player 1 win ", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(applicationContext, "player 2 win ", Toast.LENGTH_LONG).show()
        } // end if
    } // end checkWinner()

    fun autoPlay(){
        // check empty cells
        val emptyCells = ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            } // end if
        } // end for
        // select random insex
        val randomIndex = Random().nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randomIndex]
        // interpreter index to Button
        var btnSelected :Button?= null
        when(cellID){
            1->btnSelected = btn1
            2->btnSelected = btn2
            3->btnSelected = btn3
            4->btnSelected = btn4
            5->btnSelected = btn5
            6->btnSelected = btn6
            7->btnSelected = btn7
            8->btnSelected = btn8
            9->btnSelected = btn9
            else->{
                btnSelected = btn1
            }

        }// end when
        if((winner!= 1 && winner!=2)){
            playGame(cellID , btnSelected)
        }
        else
            return


    }// end autoPlay() function

} // end class
