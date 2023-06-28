package com.example.myappbasquet.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private val matchesViewModel by viewModels<HomeViewModel>()
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // funcion que llama al viewmodel
        matchesObserve()

        binding.ivback.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_loginStepOneFragment)
        }
        binding.titleHome.setOnClickListener {
            matchesObserve()
        }
    }

    // esta funcion llama al viewmodel para obtener los datos de firestore
    private fun matchesObserve() {
        matchesViewModel.getMatches("Bryan_Hualpin")
        matchesViewModel.matchesModel.observe(viewLifecycleOwner, Observer {

            binding.titleHome.text =
                it.equipo_local + " vs " + it.equipo_visitante + " : " + it.resultado
            binding.titleHome.visibility = View.VISIBLE
            Toast.makeText(
                requireContext(),
                it.equipo_local + " vs " + it.equipo_visitante + " : " + it.resultado,
                Toast.LENGTH_SHORT
            ).show()

        })
        matchesViewModel.isloading.observe(viewLifecycleOwner, Observer {
            binding.progressCircular.isVisible = it

        })
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {

                }
            }
    }
}