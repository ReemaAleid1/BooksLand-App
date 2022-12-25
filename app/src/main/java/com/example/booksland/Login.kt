package com.example.booksland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.booksland.R.layout.activity_login
import com.example.booksland.databinding.ActivityLoginBinding
import com.example.booksland.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {

    lateinit var authentication : FirebaseAuth
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login)

        authentication = FirebaseAuth.getInstance()

        authentication.signOut()

        binding.loginbtn.setOnClickListener {
            login()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }


    private fun login(){

        val email = binding.emailtxt.text.toString()

        val editPassword = findViewById(R.id.passwordtxt) as EditText
        val password = editPassword.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    authentication.signInWithEmailAndPassword(email, password).await()

                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@Login, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}




