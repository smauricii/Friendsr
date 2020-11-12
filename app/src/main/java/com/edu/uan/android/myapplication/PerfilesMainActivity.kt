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


        val caracteristicas1 = Caracteristicas("Natalia Marino","Ojos claros, le gusta salir al parque con amigos, le gustan la personas alegres",R.drawable.mujer2)
        val caracteristicas2 = Caracteristicas("Jose Ramon","Intrepido, jugador de futbol, alto, le gustan las mujeres morenas",R.drawable.hombre1)
        val caracteristicas3 = Caracteristicas("Anguie Tatiana","Persona intrepida, muy buena estudiante, le gusta comer empanadas y la frijolada ",R.drawable.mujer3)
        val caracteristicas4 = Caracteristicas("Andres Sepulveda","Un poco despistado, le gusta el baloncesto y la natacion, ademas de compartit tiempo con sus amigos",R.drawable.hombre2)
        val caracteristicas5 = Caracteristicas("Sol Agudelo","Mujer alta de lindos sentimientos, tiene dos perros que saca a pasear cada mañana, de ojos verdes y muy responsable",R.drawable.nina)
        val caracteristicas6 = Caracteristicas("Karen bermudez","De estatura promedio, le gusta salir con amigos, muy buena persona nunca le fallaria a nadie",R.drawable.mujer4)
        val caracteristicas7 = Caracteristicas("Miguel Horacio","de estatura alta, le gusta salir a fiestas, es intrepido, confia en cualquier persona",R.drawable.lil)

        val listaCaracteristicas = listOf(caracteristicas1,caracteristicas2,caracteristicas3,caracteristicas4,caracteristicas5,caracteristicas6,caracteristicas7)

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