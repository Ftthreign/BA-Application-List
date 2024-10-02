package com.example.ba_application_list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ba_application_list.activity.AboutActivity
import com.example.ba_application_list.adapter.ListCharacterAdapter
import com.example.ba_application_list.databinding.ActivityMainBinding
import com.example.ba_application_list.modelData.Character

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacter: RecyclerView
    private lateinit var mainBinding : ActivityMainBinding
    private val characterList = ArrayList<Character>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rvCharacter = mainBinding.rvCharacter
        rvCharacter.setHasFixedSize(true)


        characterList.addAll(getCharacterData())
        showRecyclerList()
    }

    private fun getCharacterData() : ArrayList<Character> {
        val characterName = resources.getStringArray(R.array.character_data_name)
        val characterPicture = resources.getStringArray(R.array.character_data_photo)
        val characterSchool = resources.getStringArray(R.array.character_data_school_name)
        val characterDescription = resources.getStringArray(R.array.character_data_description)
        val characterUrl = resources.getStringArray(R.array.character_url)
        val weaponName = resources.getStringArray(R.array.character_data_weapon_name)
        val weaponPicture = resources.getStringArray(R.array.character_data_weapon_icon)
        val listCharacter = ArrayList<Character>()
        for (index in characterName.indices) {
            val character = Character(
                name = characterName[index],
                picture = characterPicture[index],
                school = characterSchool[index],
                url = characterUrl[index],
                description = characterDescription[index],
                weapon = weaponName[index],
                weapPic = weaponPicture[index]
            )
            listCharacter.add(character)
        }
        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        rvCharacter.adapter = ListCharacterAdapter(characterList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}