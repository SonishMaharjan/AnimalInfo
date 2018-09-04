package com.zoo.so_ni.animalinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal__info.*

class Animal_Info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal__info)

        val bundle:Bundle = intent.extras
        val name = bundle.getString("name")
        val des = bundle.getString("des")
        val img = bundle.getInt("image")

        animal_image.setImageResource(img)
        animal_name.text = name
        animal_des.text = des



    }
}
