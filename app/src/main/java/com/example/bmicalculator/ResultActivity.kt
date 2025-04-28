package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityResultBinding
import java.lang.String.format

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmiResult = intent.getDoubleExtra("bmi result", 0.00)
        val BMItype = intent.getStringExtra("BMI Type")

        binding.bmiResultTV.text = "BMI Result : %.4f".format(bmiResult)
        binding.bmiResultTypeTV.text = "BMI Type: $BMItype"

    }
}
