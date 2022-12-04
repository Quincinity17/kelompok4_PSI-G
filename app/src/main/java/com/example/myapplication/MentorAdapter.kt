package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_mentor.view.*

class MentorAdapter (private val mentorList: ArrayList<PostResponse>):
    RecyclerView.Adapter<MentorAdapter.postViewHolder>(){

        inner class postViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(postResponse: PostResponse){
                with(itemView){
                    val  name= "${postResponse.name}"
                    val about = "${postResponse.about}"
                    title_mentor.text = name
                    desc_mentor.text = about
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        val view = LayoutInflater.from(parent. context).inflate(R.layout.card_mentor, parent, false)
        return postViewHolder(view)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        holder.bind(mentorList[position])
    }

    override fun getItemCount(): Int {
        return mentorList.size
    }

}