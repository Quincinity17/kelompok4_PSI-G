package com.example.myapplication

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  kategoriList = listOf<Kategori>(
            Kategori(
                R.drawable.
            )
        )


        val frgmentHome = Homepages()
        val frgmentAccount = Accounts()
        val frgmentNotification = Notifications()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, frgmentHome)
            commit()
        }

//        populateKategori()

        study.setOnClickListener{
            study.setBackgroundColor(R.color.black)
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffBA15")));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_study));
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_gray)
            textAkun.setTextColor(Color.GRAY)
//            change contact
            imageOperator.setImageResource(R.drawable.ic_operator_gray)
            textOperator.setTextColor(Color.GRAY)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, frgmentHome)
                commit()
            }
        }
        opt1.setOnClickListener{
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_study_gray));
//            change contact
            imageOperator.setImageResource(R.drawable.ic_operator_yellow)
            textOperator.setTextColor(Color.parseColor("#ffBA15"))
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_gray)
            textAkun.setTextColor(Color.GRAY)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, frgmentAccount)
                commit()
            }
        }

        opt2.setOnClickListener{
//            change study
            study.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            study.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_study_gray));
//            change account
            imageAkun.setImageResource(R.drawable.ic_account_yellow)
            textAkun.setTextColor(Color.parseColor("#ffBA15"))
//            change contact
            imageOperator.setImageResource(R.drawable.ic_operator_gray)
            textOperator.setTextColor(Color.GRAY)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, frgmentNotification)
                commit()
            }
        }
    }

    }
