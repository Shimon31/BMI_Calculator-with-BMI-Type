package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val meter = 0.3048

        binding.calculateBtn.setOnClickListener {

            val height = binding.heightET.text.toString().toDouble() * meter
            val weight = binding.weightET.text.toString().toDouble()

            val bmiResult = weight / (height * height).toDouble()

            val result =when{
                bmiResult in 1.00..18.00 ->"Under weight"
                bmiResult in 18.1..24.00 ->"Perfect"
                bmiResult in 25.00..30.00 ->"Overweight"
                else -> "Obessity"
            }

            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("bmi result", bmiResult)
            intent.putExtra("BMI Type",result)
            startActivity(intent)
        }

    }
}