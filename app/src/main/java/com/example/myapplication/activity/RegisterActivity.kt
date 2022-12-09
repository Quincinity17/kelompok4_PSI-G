package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragment.LoginMentee
import com.example.myapplication.fragment.LoginMentor
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        fragmentReplace(LoginMentee())

        mentorFill.setOnClickListener{
            loginText.setTextColor(ContextCompat.getColor(this,R.color.grey))
            mentorFill.setBackgroundResource(R.drawable.button_switch)
            registerText.setTextColor(ContextCompat.getColor(this,R.color.black))
            menteeFill.setBackgroundResource(R.color.transparant)
            fragmentReplace(LoginMentor())
        }

        menteeFill.setOnClickListener{
            registerText.setTextColor(ContextCompat.getColor(this,R.color.grey))
            menteeFill.setBackgroundResource(R.drawable.button_switch)
            loginText.setTextColor(ContextCompat.getColor(this,R.color.black))
            mentorFill.setBackgroundResource(R.color.transparant)
            fragmentReplace(LoginMentee())
        }


        signupLink.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))

        }
        input.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun fragmentReplace(tampilanFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fill_fragment, tampilanFragment)
        fragmentTransaction.commit()
    }
}