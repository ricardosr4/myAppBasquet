package com.example.myappbasquet.ui.fragment.otros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R


class PantallaDosFragment : Fragment(R.layout.fragment_pantalla_dos) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIrTres = requireView().findViewById<Button>(R.id.btnPantallaTres)
        val btnIrUno = requireView().findViewById<Button>(R.id.btnPantallaUno)

        btnIrTres.setOnClickListener {
          //  findNavController().navigate(R.id.action_pantallaDosFragment_to_pantallaTresFragment)
        }
        btnIrUno.setOnClickListener {
           // findNavController().navigate(R.id.action_pantallaDosFragment_to_pantallaUnoFragment)
        }
    }
}
