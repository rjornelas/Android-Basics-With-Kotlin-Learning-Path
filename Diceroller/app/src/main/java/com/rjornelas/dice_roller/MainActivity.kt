package com.rjornelas.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    private lateinit var ivDiceRolled: ImageView
    private lateinit var tvDiceRolled: TextView
    private lateinit var tvTitle: TextView
    private lateinit var btnRoll: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        btnRoll.setOnClickListener {
            tvTitle.text = ""
            rollDice()
        }
    }

    private fun initUi() {
        btnRoll = findViewById(R.id.btnRoll)
        ivDiceRolled = findViewById(R.id.ivDiceRolled)
        tvDiceRolled = findViewById(R.id.tvDiceRolledResult)
        tvTitle = findViewById(R.id.tvTitle)
    }

    private fun rollDice() {
        val dice = Dice(6)
        setDiceRolledImage(dice.roll())
    }

    private fun setDiceRolledImage(diceRolled: Int) {
        val drawableResource = when (diceRolled) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        ivDiceRolled.setImageResource(drawableResource)
        ivDiceRolled.contentDescription = diceRolled.toString()
        tvDiceRolled.text = String.format("Rolled: $diceRolled")
    }
}