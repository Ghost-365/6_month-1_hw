package com.example.lesson1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {

                val text= result.data?.getStringExtra("Val")
                binding.etFirst.setText(text)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            if (binding.etFirst.text.isEmpty()) {
                Toast.makeText(this, "EditText не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Key", binding.etFirst.text.toString())
                setResult(Activity.RESULT_OK, intent)
                launcher.launch(intent)
            }
        }

    }

}
