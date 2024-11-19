package com.example.tayamorinvilleassignment2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
            if(ContextCompat.checkSelfPermission(this, "com.example.tayamorinvilleassignment2.MSE412") != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf("com.example.tayamorinvilleassignment2.MSE412"), 100)
            }
            else {
                val explicitIntent = Intent(this, SecondActivity::class.java)
                startActivity(explicitIntent)
            }
        }

        // Implicit Intent
        val implicitButton = findViewById<Button>(R.id.implicitBtn)
        implicitButton.setOnClickListener{
            // Intent with action matching the action specified for second activity in AndroidManifest.xml
            if(ContextCompat.checkSelfPermission(this, "com.example.tayamorinvilleassignment2.MSE412") != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf("com.example.tayamorinvilleassignment2.MSE412"), 100)
            }
            else{
                val implicitIntent = Intent("android.intent.action.SECONDACTIVITY")
                startActivity(implicitIntent)
            }
        }

        // Image Activity Intent
        val imageActivityButton = findViewById<Button>(R.id.viewImageBtn)
        imageActivityButton.setOnClickListener{
            val intent = Intent(this, ViewImageActivity::class.java)
            startActivity(intent)
        }
    }
}