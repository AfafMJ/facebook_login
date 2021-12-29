package com.afaf.facebook_login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var edpassword: EditText
    lateinit var dbhr: DBHlpr
    lateinit var btlogin: Button
    lateinit var btsingup: Button
    lateinit var pw: String
    lateinit var spf: SharedPreferences
    lateinit var editr: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.etEmail)
        edpassword = findViewById(R.id.etPassword)
        btlogin = findViewById(R.id.btlogIn)
        btsingup = findViewById(R.id.btSignUp)
        dbhr = DBHlpr(applicationContext)
        spf = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()

        btsingup.setOnClickListener {
            Intent(this, SignUp::class.java).apply {
                startActivity(this)
            }

            btlogin.setOnClickListener {
                var s1 = email.text.toString()
                var s2 = edpassword.text.toString()
                pw = dbhr.checkpassword(s1)
                if (pw.equals(s2)) {
                    editr.putString("mob", s1).commit()

                    Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT)
                        .show();


                    Intent(this, HomePage::class.java).apply {
                        startActivity(this)
                    }

                } else {
                    Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT)
                        .show();
                }
            }

        }
    }
}