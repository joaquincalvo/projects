package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{

            rollDice()



            //forma sencilla
            /* val resultTextView:TextView=findViewById(R.id.textView)
                 val valor=1..6
                 val aleat=valor.random()
                 resultTextView.text="$aleat"
             */
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val dadoImg:ImageView=findViewById(R.id.imageView)

        when(diceRoll){
            1->dadoImg.setImageResource(R.drawable.dice_1)
            2->dadoImg.setImageResource(R.drawable.dice_2)
            3->dadoImg.setImageResource(R.drawable.dice_3)
            4->dadoImg.setImageResource(R.drawable.dice_4)
            5->dadoImg.setImageResource(R.drawable.dice_5)
            6->dadoImg.setImageResource(R.drawable.dice_6)

        }
        val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }


}

//clase dice con sus métodos
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }

}

