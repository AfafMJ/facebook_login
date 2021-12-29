package com.afaf.facebook_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var logo : ImageView
    lateinit var animation: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logo = findViewById(R.id.logo)
        animation = findViewById(R.id.animaition)

        logo.animate().translationY(-300F).setDuration(700).setStartDelay(400).withEndAction {

            val intent = Intent(this,loginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()

        }
    }
}