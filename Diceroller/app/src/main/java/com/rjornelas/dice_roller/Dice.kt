package com.rjornelas.dice_roller

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}