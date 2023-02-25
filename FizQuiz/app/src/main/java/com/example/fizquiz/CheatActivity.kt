package com.example.fizquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CheatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat_activity)
        findViewById<TextView>(R.id.cheatText).apply { }
    }

    fun clickMain(view: View) {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}