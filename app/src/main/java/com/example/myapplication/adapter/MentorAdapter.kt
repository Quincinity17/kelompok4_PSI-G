package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Mentor
import kotlinx.android.synthetic.main.card_mentor.view.*

class MentorAdapter (private val mentorList: ArrayList<Mentor>):
    RecyclerView.Adapter<MentorAdapter.UserViewHolder>(){

        inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(mentor: Mentor){
                with(itemView){
                    val  name= "${mentor.nama}"
                    val about = "${mentor.desc}"
                    title_mentor.text = name
                    desc_mentor.text = about
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent. context).inflate(R.layout.card_mentor, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(mentorList[position])
    }

    override fun getItemCount(): Int {
        return mentorList.size
    }

}