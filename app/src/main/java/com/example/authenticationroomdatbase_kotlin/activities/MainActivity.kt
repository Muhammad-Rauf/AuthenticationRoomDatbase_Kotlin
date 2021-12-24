package com.example.authenticationroomdatbase_kotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationroomdatbase_kotlin.R
import com.example.authenticationroomdatbase_kotlin.mvm.RegisterViewModel
import com.example.authenticationroomdatbase_kotlin.room.RegisterEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: RegisterViewModel
    private lateinit var fname: EditText
    private lateinit var lname: EditText
    private lateinit var email: EditText
    private lateinit var password_edittext: EditText
    private lateinit var btnsignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fname=findViewById(R.id.edittextFnameid)
        lname=findViewById(R.id.edittextLnameid)
        email=findViewById(R.id.edittextEmailid)
        password_edittext=findViewById(R.id.edittextPasswordid)
        btnsignup = findViewById<Button>(R.id.btnsignupid)

        btnsignup.setOnClickListener {
            mUserViewModel= ViewModelProvider(this).get(RegisterViewModel::class.java)
            insertData()

        }


        btnalreadyregisterid.setOnClickListener {
            mUserViewModel= ViewModelProvider(this).get(RegisterViewModel::class.java)
            val intent=Intent(this, LoginData::class.java)
            startActivity(intent)
        }

    }

    private fun insertData() {

        val firstname=fname.text.toString()
        val lastname=lname.text.toString()
        val email=email.text.toString()
        val password=password_edittext.text.toString()
        if (inputcheck(firstname,lastname,email,password))
        {
            val user = RegisterEntity(firstname, lastname, email, password)
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Successfully addedd data", Toast.LENGTH_LONG).show()
            val intent=Intent(this, LoginData::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "field may not Empty", Toast.LENGTH_LONG).show()

        }
    }
    private fun inputcheck(firstname:String,lastname:String,email: String,password:String):Boolean {
        return !(TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(email)||TextUtils.isEmpty(password))

    }
}