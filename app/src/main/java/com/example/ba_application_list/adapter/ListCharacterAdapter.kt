package com.example.ba_application_list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ba_application_list.activity.DetailActivity
import com.example.ba_application_list.modelData.Character
import com.example.ba_application_list.R

class ListCharacterAdapter(private val listCharacter : ArrayList<Character>) : RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>(){

    inner class ListViewHolder(viewItem : View)  : RecyclerView.ViewHolder(viewItem) {
        val tvName : TextView = viewItem.findViewById(R.id.tv_item_name)
        val tvSchool : TextView = viewItem.findViewById(R.id.school_type)
        val ivImage : ImageView = viewItem.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_character_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int,
    ) {
        val (name, description, school, picture, url, weapon, weapPic) = listCharacter[position]
        holder.tvName.text = name
        holder.tvSchool.text = school
        Glide.with(holder.itemView.context).load(picture).into(holder.ivImage)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val detailIntent = Intent(context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.CHARACTER_NAME, name)
                putExtra(DetailActivity.CHARACTER_SCHOOL, school)
                putExtra(DetailActivity.CHARACTER_PICTURE, picture)
                putExtra(DetailActivity.CHARACTER_URL, url)
                putExtra(DetailActivity.CHARACTER_DESCRIPTION, description)
                putExtra(DetailActivity.WEAPON_NAME, weapon)
                putExtra(DetailActivity.WEAPON_PICTURE, weapPic)

            }
            context.startActivity(detailIntent)
        }
    }

    override fun getItemCount(): Int = listCharacter.size
}