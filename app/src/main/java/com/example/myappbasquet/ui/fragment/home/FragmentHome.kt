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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.R
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.databinding.FragmentHomeBinding
import com.example.myappbasquet.ui.adapter.MatchesAdapter

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private val matchesViewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MatchesAdapter
    private val matchList = mutableListOf<MatchesEntry>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // todo aqui inicializamos el adapter con su respectivo clicklistener para poder darle click a los items
        initRecyclerView()


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo funcion que llama al viewmodel
        matchesObserve()

    }

    private fun initRecyclerView() {
        adapter = MatchesAdapter(matchList) { dogList, viewId: Int -> matchesClicked(dogList, viewId) }
        binding.recyclerViewMatches.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewMatches.adapter = adapter
    }

    // esta funcion llama al viewmodel para obtener los datos de firestore
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun matchesObserve() {
        matchesViewModel.getMatches("Bryan_Hualpin")  // aqui me traigo los datos de firestore

        // observe los datos que trae la funcion de arriba
        matchesViewModel.matchesModel.observe(viewLifecycleOwner, Observer {

            val matches: List<MatchesEntry> = it ?: emptyList()
            matchList.addAll(matches)
            adapter.notifyDataSetChanged()

        })
        matchesViewModel.isloading.observe(viewLifecycleOwner, Observer {
            binding.progressCircular.isVisible = it

        })
    }

    // todo esta funcion se encarga del click waxo
    private fun matchesClicked(matchList: MatchesEntry, viewId: Int) {
        when (viewId) {
            R.id.titleEquipos -> {
                Toast.makeText(
                    requireContext(),
                    "el resultado del equipo es =" + matchList.resultado,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

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