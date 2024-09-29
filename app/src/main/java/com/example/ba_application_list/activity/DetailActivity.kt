package com.example.ba_application_list.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ba_application_list.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra(CHARACTER_NAME)
        val school = intent.getStringExtra(CHARACTER_SCHOOL)
        val picture = intent.getStringExtra(CHARACTER_PICTURE)
        val description = intent.getStringExtra(CHARACTER_DESCRIPTION)
        val weaponName = intent.getStringExtra(WEAPON_NAME)
        val weaponPic = intent.getStringExtra(WEAPON_PICTURE)
        val characterLink = intent.getStringExtra(CHARACTER_URL)

        supportActionBar?.title = "$name Details"


        binding.tvDetailName.text = name
        binding.tvDetailSchool.text = school
        binding.tvDetailDescription.text = description
        binding.tvweaponName.text = weaponName
        Glide.with(this).load(weaponPic).into(binding.ivweaponPic)
        Glide.with(this).load(picture).into(binding.ivDetailPicture)
        binding.bShareButton.setOnClickListener{
            val shareAction = Intent()
            shareAction.action = Intent.ACTION_SEND
            shareAction.putExtra(Intent.EXTRA_TEXT, "Share $name Character url: $characterLink")
            shareAction.type = "text/plain"
            startActivity(Intent.createChooser(shareAction, "Share To:"))
        }
    }

    companion object {
        const val CHARACTER_NAME = "character name"
        const val CHARACTER_SCHOOL = "character school"
        const val CHARACTER_PICTURE = "character picture"
        const val CHARACTER_DESCRIPTION = "character description"
        const val CHARACTER_URL = "character url"
        const val WEAPON_NAME = "weapon name"
        const val WEAPON_PICTURE = "weapon picture"
    }
}