package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val costService = findViewById<TextView>(R.id.editTextText)
        val solution = findViewById<TextView>(R.id.textView3)
        val checkBox1 = findViewById<RadioButton>(R.id.option_twenty_percent)
        val checkBox2 = findViewById<RadioButton>(R.id.option_twenty_percent2)
        val checkBox3 = findViewById<RadioButton>(R.id.option_twenty_percent3)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        var solutionNum = 0.0  // Use a Double to store decimal values

        // Convert the text to a Double if it's a valid number

        buttonCalculate.setOnClickListener(){
            val costText = costService.text.toString()
            val costValue = costText.toDoubleOrNull()
            if (costValue != null) {
                if (checkBox1.isChecked) {
                    solutionNum = costValue * 0.2
                } else if (checkBox2.isChecked) {
                    solutionNum = costValue * 0.18
                } else if (checkBox3.isChecked) {
                    solutionNum = costValue * 0.15
                }
            } else {

            }
            solution.text = solutionNum.toString()
        }


        // Convert solutionNum to a String before setting it as the text
        solution.text = solutionNum.toString()
    }
}
