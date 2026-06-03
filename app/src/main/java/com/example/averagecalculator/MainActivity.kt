package com.example.averagecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val numbers = IntArray(10)
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val enterButton = findViewById<Button>(R.id.enterButton)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val averageButton = findViewById<Button>(R.id.averageButton)

        enterButton.setOnClickListener {
            val userNumber = numberEditText.text.toString().toInt()

            if (counter >= 10) {
                feedbackTextView.text = "Array is full - no more values"
            } else { numbers[counter] = userNumber
                counter++
                feedbackTextView.text = "Number added"

            }
        }

        averageButton.setOnClickListener {
            var sum = 0
            var index = 0

            while (index < 10) {
                sum+= numbers[index]
                index++
            }

            val average = sum / 10
            feedbackTextView.text = "Average :$average"

        }













        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}