package com.example.thesocialnetwork


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.thesocialnetwork.feed.FeedActivity
import com.example.thesocialnetwork.login.LoginActivity
import com.example.thesocialnetwork.signup.SignUpActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login).setOnClickListener(View.OnClickListener {
            val intent = Intent (this,LoginActivity::class.java)
            startActivity(intent)
        })
        findViewById<Button>(R.id.register).setOnClickListener(View.OnClickListener {
            val intent = Intent (this,SignUpActivity::class.java)
            startActivity(intent)
        })
        findViewById<Button>(R.id.feed).setOnClickListener(View.OnClickListener {
            val intent = Intent (this,FeedActivity::class.java)
            startActivity(intent)
        })

    }
}