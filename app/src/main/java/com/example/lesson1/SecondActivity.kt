package com.example.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson1.databinding.ActivityMainBinding
import com.example.lesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etSecond.setText(intent.getStringExtra("Key"))

        binding.btnGoBack.setOnClickListener{
            val intent=Intent()
            intent.putExtra("Val", binding.etSecond.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }


    }

}