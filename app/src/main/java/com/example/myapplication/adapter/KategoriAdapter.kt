package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Kategori
import com.example.myapplication.R

class KategoriAdapter (private val kategoriList: List<Kategori>):
    RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

    inner class KategoriViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val kategoriImageView: ImageView = itemView.findViewById(R.id.cover)
        val kategoriTitleTv: TextView = itemView.findViewById(R.id.title)
        val kategoriDescTv: TextView = itemView.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_kategori, parent, false)
        return KategoriViewHolder(view)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val kategori = kategoriList[position]
        holder.kategoriImageView.setImageResource(kategori.kategoriImage)
        holder.kategoriTitleTv.text = kategori.kategoriTitle
        holder.kategoriDescTv.text = kategori.kategoriDesc
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }
}