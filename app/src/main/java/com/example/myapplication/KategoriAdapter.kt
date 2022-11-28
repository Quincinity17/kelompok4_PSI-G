package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter (
    private val context: Context,
    private  val kategori: List<Kategori>,
    val listener: (Kategori) -> Unit): RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

        class KategoriViewHolder(view: View): RecyclerView.ViewHolder(view) {

            val covrCard = view.findViewById<ImageView>(R.id.cover)
            val titleCard = view.findViewById<TextView>(R.id.title)
            val descCard = view.findViewById<TextView>(R.id.desc)

            fun bindView(Kategori: Kategori, listener: (Kategori) -> Unit){
                covrCard.setImageResource(Kategori.cover)
                titleCard.text = Kategori.title
                descCard.text = Kategori.desc

            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        return KategoriViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_kategori, parent, false)
        )
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        holder.bindView(kategori[position], listener)
    }

    override fun getItemCount(): Int = kategori.size
}