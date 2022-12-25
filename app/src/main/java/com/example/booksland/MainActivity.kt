package com.example.booksland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var louginButton =findViewById(R.id.btnlogin) as Button

        louginButton.setOnClickListener(){

            // go to login activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}