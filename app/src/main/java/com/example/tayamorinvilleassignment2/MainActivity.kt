package com.example.tayamorinvilleassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Explicit Intent
        val explicitButton = findViewById<Button>(R.id.explicitBtn)
        explicitButton.setOnClickListener{
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        // Implicit Intent
        val implicitButton = findViewById<Button>(R.id.implicitBtn)
        implicitButton.setOnClickListener{
            // Intent with action matching the action specified for second activity in AndroidManifest.xml
            val implicitIntent = Intent("android.intent.action.SECONDACTIVITY")
            startActivity(implicitIntent)
        }

        // Image Activity Intent
        val imageActivityButton = findViewById<Button>(R.id.viewImageBtn)
        imageActivityButton.setOnClickListener{
            val intent = Intent(this, ViewImageActivity::class.java)
            startActivity(intent)
        }
    }
}