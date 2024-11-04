package com.example.homework

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OutputActivity : AppCompatActivity() {

    lateinit var btnClick: Button
    lateinit var editTextNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_output)
        val email = intent.getStringExtra("email")
        val textViewEmailCatch = findViewById<TextView>(R.id.textViewEmailCatch)
        textViewEmailCatch.text = email
        btnClick.setOnClickListener {
            val intent = Intent(this, OutputActivity::class.java)
            val num = editTextNumber.text.toString().toInt() * 2
//            need help with this part
            editTextNumber.text = num.toString()
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}