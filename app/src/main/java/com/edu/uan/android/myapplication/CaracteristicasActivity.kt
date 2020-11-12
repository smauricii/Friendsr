package com.edu.uan.android.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_caracteristicas.*

class CaracteristicasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caracteristicas)

        val caracteristicas = intent.getSerializableExtra("caracteristicas") as Caracteristicas

        txt_nombre_persona.text = caracteristicas.nombre
        ratingBar2.setOnRatingBarChangeListener { ratingBar, rating, fromUSer -> saveRating() }

        val preferences = getPreferences(Context.MODE_PRIVATE)
        ratingBar2.setRating(preferences.getFloat(caracteristicas.nombre, 1.0f))

        //ratingBar2.rating = caracteristicas.ratingBar
        txt_descripcion.text = caracteristicas.descripcion
        imageViewPersona.setImageResource(caracteristicas.imagen)

    }

    fun saveRating(): Boolean {

        val preferences = getPreferences(Context.MODE_PRIVATE)
       val  caracteristicas = intent.getSerializableExtra("caracteristicas") as Caracteristicas
        with(preferences.edit()) {
            putFloat(caracteristicas.nombre, ratingBar2.rating)
            commit()
        }
        return true
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }
}