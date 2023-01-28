package com.route.islami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        android.os.Handler(Looper.getMainLooper()).postDelayed({
           val intent:Intent=Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}