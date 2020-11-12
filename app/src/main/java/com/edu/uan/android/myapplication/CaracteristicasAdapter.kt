package com.edu.uan.android.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_caracteristicas.*
import kotlinx.android.synthetic.main.item_caracteristicas.view.*

class CaracteristicasAdapter(private val mContext:Context, private val listaCaracteristicas:List<Caracteristicas>):ArrayAdapter<Caracteristicas>(mContext,0, listaCaracteristicas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_caracteristicas, parent,false)

        val caracteristicas = listaCaracteristicas[position]



        layout.txt_nombre.text = caracteristicas.nombre

       // layout.ratingBar.text = caracteristicas.ratingBar.toString()
        layout.imageView.setImageResource(caracteristicas.imagen)

        return layout
    }


}