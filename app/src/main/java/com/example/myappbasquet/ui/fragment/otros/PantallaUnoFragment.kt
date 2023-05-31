package com.example.myappbasquet.ui.fragment.otros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R


class PantallaUnoFragment : Fragment(R.layout.fragment_pantalla_uno) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIrDos = requireView().findViewById<Button>(R.id.btnPantallaDos)
        val btnTres = requireView().findViewById<Button>(R.id.btnPantallaTres)

        btnIrDos.setOnClickListener {
        //    findNavController().navigate(R.id.action_pantallaUnoFragment_to_pantallaDosFragment)

            }
        btnTres.setOnClickListener {
          //  findNavController().navigate(R.id.action_pantallaUnoFragment_to_pantallaTresFragment)

        }
    }

}