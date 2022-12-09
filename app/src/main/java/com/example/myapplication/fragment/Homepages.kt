package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.adapter.KategoriAdapter
import com.example.myapplication.adapter.MentorAdapter
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.model.Kategori
import com.example.myapplication.model.Mentor
import com.example.myapplication.model.MentorRespons
import kotlinx.android.synthetic.main.fragment_homepages.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//private lateinit var adapter: KategoriAdapter
//private lateinit var recyclerView: RecyclerView
//private lateinit var recyclerList: ArrayList<Kategori>



/**
 * A simple [Fragment] subclass.
 * Use the [Homepages.newInstance] factory method to
 * create an instance of this fragment.
 */
class Homepages : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerList: ArrayList<Kategori>
    private lateinit var kategoriAdapter: KategoriAdapter


    private lateinit var mentorList: ArrayList<Mentor>

    lateinit var cover : Array<Int>
    lateinit var title : Array<String>
    lateinit var desc : Array<String>

    lateinit var gambarDummy : Array<Int>
    lateinit var namaDummy : Array<String>
    lateinit var pekerjaanDummy : Array<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //kategori
        init()
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.KategoriDaftar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        kategoriAdapter = KategoriAdapter(recyclerList)
        recyclerView.adapter = kategoriAdapter

        showMentor()


        }





    private fun init(){
        recyclerList = arrayListOf<Kategori>()

        cover = arrayOf(
            R.drawable.img_persiapan,
            R.drawable.img_pemrograman,
            R.drawable.img_gitar
        )
        title = arrayOf(
            "Persiapan karir",
            "Pemrograman",
            "Gitar"
        )
        desc = arrayOf(
            "Persiapkan karir Anda mulai dari sekarang",
            "Belajar pemrograman dengan metode yang menyenangkan",
            "Bermain dan belajar gitar dengan mentor yang asik"
        )

        for (i in cover.indices){
            val content = Kategori(cover[i],title[i],desc[i])
            recyclerList.add(content)
        }
    }

    private fun showMentor(){
        EksploreList.setHasFixedSize(true)
        EksploreList.layoutManager = LinearLayoutManager(context)
        RetrofitClient.instance.getPosts().enqueue(object : Callback<MentorRespons>{
            override fun onResponse(call: Call<MentorRespons>, response: Response<MentorRespons>) {
                val listResponse = response.body()?.data
                listResponse?.let { mentorList.addAll(it) }
                val adapter = MentorAdapter(mentorList)
                EksploreList.adapter = adapter
            }

            override fun onFailure(call: Call<MentorRespons>, t: Throwable) {
//                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })




    }
}