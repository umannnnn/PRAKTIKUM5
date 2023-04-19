package com.example.praktikum5_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Card_MahasiswaAdapter(private val context: Context, private
val dataList: List<Inis_Variable>, val listener: (Inis_Variable) ->
Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType:
        Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(
                R.layout.card_mahasiswalayout,
                parent, false
            )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val myHolder = holder as MyViewHolder
        myHolder.bindView(dataList[position], listener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val fotomhs = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val namamhs = itemView.findViewById<TextView>(R.id.nama_mahasiswa)
        val nimmhs = itemView.findViewById<TextView>(R.id.nim_mahasiswa)
        val telpon = itemView.findViewById<TextView>(R.id.telp_mahasiswa)

        fun bindView(mhs: Inis_Variable, listener: (Inis_Variable) -> Unit)
        {
            cardView.setOnClickListener {
                listener(mhs)
                val intent = Intent(context, Detail::class.java)
                intent.putExtra("nama_mhs", mhs.Namamhs)
                intent.putExtra("nim_mhs", mhs.Nimmhs)
                intent.putExtra("telp_mhs", mhs.Telpmhs)
                context.startActivity(intent)
            }
            fotomhs.setImageResource(mhs.fotomhs)
            namamhs.text = mhs.Namamhs
            nimmhs.text = mhs.Nimmhs
            telpon.text = mhs.Telpmhs
        }
    }
}
