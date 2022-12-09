package com.example.myapplication.activity

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.fragment.Accounts
import com.example.myapplication.fragment.Homepages
import com.example.myapplication.fragment.Notifications
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentReplace(Homepages())

        //StudyButtonOnclick
        study.setOnClickListener{
            study.setBackgroundColor(R.color.black)
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffBA15")));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.ic_study
            ));
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_gray)
            textAkun.setTextColor(Color.GRAY)
//            change contact
            imageOperator.setImageResource(R.drawable.ic_notification_gray)
            textOperator.setTextColor(Color.GRAY)

            fragmentReplace(Homepages())
        }
        //NotifButtonOnclick
        opt1.setOnClickListener{
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.ic_study_gray
            ));
//            change contact
            imageOperator.setImageResource(R.drawable.ic_notification_yellow)
            textOperator.setTextColor(Color.parseColor("#ffBA15"))
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_gray)
            textAkun.setTextColor(Color.GRAY)

            fragmentReplace(Accounts())
        }
        //AccountbuttonOnclick
        opt2.setOnClickListener{
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.ic_study_gray
            ));
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_yellow)
            textAkun.setTextColor(Color.parseColor("#ffBA15"))
//            change contact
            imageOperator.setImageResource(R.drawable.ic_notification_gray)
            textOperator.setTextColor(Color.GRAY)

            fragmentReplace(Notifications())
        }
    }

    private fun fragmentReplace(tampilanFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, tampilanFragment)
        fragmentTransaction.commit()
    }

    }
