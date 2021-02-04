package com.example.numberguessinggame

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }


    private fun init() {
        auth = Firebase.auth
        signUpButton1.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val email = emailEditText1.text.toString()
        val password = passwordEditText1.text.toString()
        val repeatPassword = repeatPasswordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()) {
            if (password == repeatPassword) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            // Sign in success, update UI with the signed-in user's information
                            d("signUp", "createUserWithEmail:success")
                            val user = auth.currentUser
                        } else {
                            // If sign in fails, display a message to the user.
                            d("signUp", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }

                        // ...
                    }
            }else{
                Toast.makeText(this, "please fill fields correctly", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
        }

    }
}