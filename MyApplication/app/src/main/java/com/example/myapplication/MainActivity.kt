package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Button
import com.example.myapplication.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button_click)

        buttonClick.setOnClickListener {
            buttonClick.visibility = INVISIBLE
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.container, MainFragment())
            ft.commit()
        }
    }
}