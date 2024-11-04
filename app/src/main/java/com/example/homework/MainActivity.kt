package com.example.homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnOkay: Button
    lateinit var btnNext: Button
    lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnOkay = findViewById(R.id.btnOkay)
        btnNext = findViewById(R.id.btnNext)
        email = findViewById(R.id.editTextEmail)
        btnOkay.setOnClickListener {
            val mail = email.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", mail)
        }
        btnNext.setOnClickListener {
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}