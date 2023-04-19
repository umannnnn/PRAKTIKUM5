package com.example.praktikum5_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class List_MahasiswaAdapter (private val context: Context, private val idol:
List<Inis_Variable>, val listener: (Inis_Variable) -> Unit) :
    RecyclerView.Adapter<List_MahasiswaAdapter.ListViewHolder>() {
    class ListViewHolder(view: View) :RecyclerView.ViewHolder(view)
    {
        val fotomhs = view.findViewById<ImageView>(R.id.img_item_photo)
        val namamhs = view.findViewById<TextView>(R.id.nama_mahasiswa)
        val nimmhs = view.findViewById<TextView>(R.id.nim_mahasiswa)
        val telpon = view.findViewById<TextView>(R.id.telp_mahasiswa)

        fun bindView( mhs: Inis_Variable, listener: (Inis_Variable) -> Unit) {
            fotomhs.setImageResource(mhs.fotomhs)
            namamhs.text = mhs.Namamhs
            nimmhs.text = mhs.Nimmhs
            telpon.text = mhs.Telpmhs
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(

            LayoutInflater.from(context).inflate(R.layout.list_mahasiswalayout,
                parent, false)
        )
    }
    override fun getItemCount(): Int = idol.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindView(idol[position], listener)
    }
}