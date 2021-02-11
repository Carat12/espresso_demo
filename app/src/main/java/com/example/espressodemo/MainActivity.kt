package com.example.espressodemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btn_login.setOnClickListener {
            val email = edit_text_email.text.toString()
            val pw = edit_text_pw.text.toString()
            if (email == "sc@gmail.com" && pw == "123")
                startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}