package com.example.myappbasquet.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.example.myappbasquet.R
import com.example.myappbasquet.ui.fragment.PantallaUnoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashScreen.setKeepOnScreenCondition{false}
        intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()

    }
}