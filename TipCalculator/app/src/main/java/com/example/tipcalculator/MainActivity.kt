package com.example.tipcalculator



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener{calculateTip()}
    }

    fun calculateTip()
    {
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val stringInTextField = binding.cost.text.toString()
        val cost = stringInTextField.toDouble()
        val roundUp = binding.roundUpSwitch.isChecked
        val tipPercentage = when (selectedId)
        {
            R.id.Amazing -> 0.20
            R.id.Good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost

        if (roundUp) {
            tip = ceil(tip)
        }


        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)







    }
}