package com.example.kotlindiceroller


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    /*
    Whenever you'd like to use a variable in a function outside of onCreate, it's often
    difficult because you shouldn't initialise it in the function. Don't ever do that.
    It makes the app lag, it's very bad practise. Another thing you can't do is initialise it
    within onCreate, because it will be local to onCreate only, not to your outside function.
    The workaround for this is to globally declare all variables here, in the activity,
    just not within onCreate, and don't make it null. You can, but it comes with headaches, null checks,
    all that annoying stuff, so instead go ahead and declare the variable using the lateinit keyword.
    This is like a promise to kotlin that you're going to initialise it later on, within onCreate.
    Once that's done, you have initialised it once, not multiple times, then you can use it anywhere,
    within whatever function body you want. It becomes global without the headaches. Great isn't it!
     */
    lateinit var imageDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialisation in Kotlin
        val diceRollButton: Button = findViewById(R.id.btnRoll)




        diceRollButton.setOnClickListener {
            rollDice()
        }

        imageDice = findViewById(R.id.ivDice)


    }


    private fun rollDice() {

        val randomInt = Random().nextInt(6) + 1

        // This is your equivalent to a switch statement in Kotlin
        val drawable = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageDice.setImageResource(drawable)


    }
}