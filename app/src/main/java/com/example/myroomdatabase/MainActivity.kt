package com.example.myroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myroomdatabase.database.AppDatabase
import com.example.myroomdatabase.database.dao.UserDao
import com.example.myroomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)
        this.userDao = this.database.userDao()
    }

    override fun onStart() {
        super.onStart()
        loadTotalUsers()

        this.binding.button.setOnClickListener {

            openNewUserActivity()
        }
    }

    private fun openNewUserActivity() {
        startActivity(Intent(this, NewUserActivity::class.java))
    }

    private fun loadTotalUsers() {
        this.binding.textView.text = "Carregando..."

        CoroutineScope(Dispatchers.IO).launch {
            val totalUsers = userDao.getTotalItems()

            withContext(Dispatchers.Main) {
                binding.textView.text = "Total de usuários:$totalUsers"
            }
        }
    }
}