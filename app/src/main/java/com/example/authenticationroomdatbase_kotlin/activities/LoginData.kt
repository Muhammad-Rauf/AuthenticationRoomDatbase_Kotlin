package com.example.authenticationroomdatbase_kotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationroomdatbase_kotlin.R
import com.example.authenticationroomdatbase_kotlin.mvm.RegisterViewModel
import com.example.authenticationroomdatbase_kotlin.room.RegisterDatabase
import kotlinx.coroutines.Dispatchers

class LoginData : AppCompatActivity() {
    private lateinit var mUserViewModel: RegisterViewModel
    private lateinit var loginemail: EditText
    private lateinit var loginpassword: EditText
    private lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_data)
        btnlogin = findViewById<Button>(R.id.btnloginid)
        loginemail = findViewById<EditText>(R.id.loginEmailid)
        loginpassword = findViewById<EditText>(R.id.loginPasswordid)

        mUserViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        btnlogin.setOnClickListener {

          var email= loginemail.text.toString()
         val password=loginpassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty())
            {

               val x = this?.let { RegisterDatabase.getDatabase(it).userDao() }
                val y = x?.searchEamil(email)
              if (y != null)
              {
                  Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                  val intent= Intent(this,DisplayData::class.java)
                  startActivity(intent)

              }
                else{
                  Toast.makeText(this, "User Email not exit", Toast.LENGTH_SHORT).show()

              }


            }


            Toast.makeText(this, "Input Required", Toast.LENGTH_SHORT).show()


        }






            }



    private fun loginData() {





    }

    }



