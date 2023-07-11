package com.example.myappbasquet.ui.fragment.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentHomeBinding
import com.example.myappbasquet.ui.adapter.MatchesAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private val matchesViewModel by viewModels<HomeViewModel>()
    lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: MatchesAdapter
    private val matchesEntry = mutableListOf<String>()


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

        binding.titleHome.setOnClickListener {
            matchesObserve()
        }
    }

    // esta funcion llama al viewmodel para obtener los datos de firestore
    @SuppressLint("SetTextI18n")
    private fun matchesObserve() {
        matchesViewModel.getMatches("Bryan_Hualpin")  // aqui me traigo los datos de firestore

        // observe los datos que trae la funcion de arriba
        matchesViewModel.matchesModel.observe(viewLifecycleOwner, Observer {

            binding.titleHome.text = it.equipo_local + " vs " + it.equipo_visitante + " : " + it.resultado
            binding.titleHome.visibility = View.VISIBLE

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