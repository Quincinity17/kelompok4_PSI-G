package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.adapter.MentorAdapter
import com.example.myapplication.api.Api
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.model.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_homepages.*
import kotlinx.android.synthetic.main.fragment_login_mentee.*
import kotlinx.android.synthetic.main.fragment_login_mentor.*
import kotlinx.android.synthetic.main.fragment_register_mentor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginMentor.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginMentor : Fragment() {

    private lateinit var mentorList: ArrayList<Mentor>
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_mentor, container, false)
        inputRegister.setOnClickListener{loginMentor()}
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginMentor.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginMentor().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun loginMentor(){
        val req = MenteeRequestLogin()
        req.email = mentorEmail.text.toString().trim()
        req.password = menteePass.text.toString().trim()

        EksploreList.setHasFixedSize(true)
        EksploreList.layoutManager = LinearLayoutManager(context)
        RetrofitClient.instance.getPostsMentee().enqueue(object : Callback<MenteeRespons>{
            override fun onResponse(call: Call<MenteeRespons>, response: Response<MenteeRespons>) {
                val user = response.body()
                startActivity(Intent(context, MainActivity::class.java))
            }

            override fun onFailure(call: Call<MenteeRespons>, t: Throwable) {
//                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}