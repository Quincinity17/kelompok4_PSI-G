package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragment.LoginMentee
import com.example.myapplication.fragment.LoginMentor
import com.example.myapplication.fragment.RegisterMentee
import com.example.myapplication.fragment.RegisterMentor
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.input
import kotlinx.android.synthetic.main.activity_register.loginText
import kotlinx.android.synthetic.main.activity_register.menteeFill
import kotlinx.android.synthetic.main.activity_register.mentorFill
import kotlinx.android.synthetic.main.activity_register.registerText
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        fragmentReplace(RegisterMentee())

        mentorFill.setOnClickListener{
            loginText.setTextColor(ContextCompat.getColor(this,R.color.grey))
            mentorFill.setBackgroundResource(R.drawable.button_switch)
            registerText.setTextColor(ContextCompat.getColor(this,R.color.black))
            menteeFill.setBackgroundResource(R.color.transparant)
            fragmentReplace(RegisterMentor())
        }

        menteeFill.setOnClickListener{
            registerText.setTextColor(ContextCompat.getColor(this,R.color.grey))
            menteeFill.setBackgroundResource(R.drawable.button_switch)
            loginText.setTextColor(ContextCompat.getColor(this,R.color.black))
            mentorFill.setBackgroundResource(R.color.transparant)
            fragmentReplace(RegisterMentee())
        }


        registerLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }
        inputRegister.setOnClickListener {
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