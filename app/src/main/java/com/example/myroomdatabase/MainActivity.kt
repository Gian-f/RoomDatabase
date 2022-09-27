package com.example.myroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myroomdatabase.database.AppDatabase
import com.example.myroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }
}