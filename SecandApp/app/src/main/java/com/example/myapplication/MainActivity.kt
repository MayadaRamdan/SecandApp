package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.MainActivity.constant.userName
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val myFirstFragment =First_Fragment()
    val myScandFragment =ScandFragment()
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        intentTest()
        searchButton()
        initFragment()
        changeButton()
    }
    private fun intentTest(){
        binding.btn.setOnClickListener{
            val intent = Intent(this , MainActivity2::class.java)
            val name =binding.editText1.text.toString()
            intent.putExtra(userName,name)
            startActivity(intent)
        }
    }
    object constant {
        val userName ="userName"
    }

    private fun searchButton(){
        binding.btn2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.google.com/")
            startActivity(intent)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun initFragment(){
      val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,myFirstFragment)
        transaction.commit()
    }
    private fun changeButton(){
        binding.btn3.setOnClickListener{
            showscandFragment()
        }
    }

    private fun showscandFragment() {

        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,myScandFragment)
        transaction.commit()
    }

}