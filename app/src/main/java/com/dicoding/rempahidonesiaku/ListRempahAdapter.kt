package com.dicoding.rempahidonesiaku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.rempahindonesiaku.R

class ListRempahAdapter (private val listRempah:ArrayList <Rempah>): RecyclerView.Adapter<ListRempahAdapter.ListViewHolder> () {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description) }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_rempah, parent, false)
        return ListViewHolder(view) }

    override fun getItemCount(): Int = listRempah.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listRempah[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailRempah::class.java)
            intentDetail.putExtra("key_rempah", listRempah[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Rempah)
    }}
