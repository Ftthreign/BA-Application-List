package com.example.ba_application_list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ba_application_list.activity.DetailActivity
import com.example.ba_application_list.modelData.Character
import com.example.ba_application_list.databinding.LayoutCharacterItemBinding

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>) :
    RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: LayoutCharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = LayoutCharacterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, school, picture, url, weapon, weapPic) = listCharacter[position]

        holder.binding.tvItemName.text = name
        holder.binding.schoolType.text = school
        Glide.with(holder.itemView.context).load(picture).into(holder.binding.imgItemPhoto)

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
