package com.edu.uan.android.myapplication

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.perfiles_activity_main.*

class PerfilesMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfiles_activity_main)


        val caracteristicas = Caracteristicas("Natalia MArino","bien zorra",R.drawable.nina)
        val caracteristicas1 = Caracteristicas("Natalia1 Marino","bien zorra1",R.drawable.nina)

        val listaCaracteristicas = listOf(caracteristicas,caracteristicas1)

        val adapter = CaracteristicasAdapter(this,listaCaracteristicas)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, CaracteristicasActivity::class.java)
            intent.putExtra("caracteristicas",listaCaracteristicas[position])
            startActivity(intent)
        }



    }




  @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }
}