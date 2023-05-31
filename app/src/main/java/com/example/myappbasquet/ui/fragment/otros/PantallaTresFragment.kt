package com.example.myappbasquet.ui.fragment.otros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R


class PantallaTresFragment : Fragment(R.layout.fragment_pantalla_tres) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIrUno = requireView().findViewById<android.widget.Button>(R.id.btnPantallaUno)

        btnIrUno.setOnClickListener {
          //  findNavController().navigate(R.id.action_pantallaTresFragment_to_pantallaUnoFragment)
        }

    }

}