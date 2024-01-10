package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val name = intent.getStringExtra(MainActivity.constant.userName).toString()

        binding.TV.text=getString(R.string.hello2)+ "  " + name
        reciveData()
        backStackActivity()


    }
    private fun reciveData(){
        val name = intent.getStringExtra(MainActivity.constant.userName).toString()
        binding.TV.text=getString(R.string.hello2)+ "  " + name

    }

    private fun backStackActivity (){
        binding.button.setOnClickListener {
            finish()
        }
    }
}