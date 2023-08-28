package com.example.myappbasquet.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentAuditBinding
import com.example.myappbasquet.databinding.FragmentForgotPasswordBinding


class FragmentAudit : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentAuditBinding

    private var localPoint: Int = 0
    private var visitPoint: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAuditBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListenerLocal()
        initListenerVisit()

    }

    private fun initListenerLocal() {
        binding.floatingRemoveLocal.setOnClickListener {
            localPoint -= 1
            setPointLocal()
        }
        binding.floatingAddLocal.setOnClickListener {
            localPoint += 1
            setPointLocal()
        }

        binding.btn1PuntoLocal.setOnClickListener {
            localPoint += 1
            setPointLocal()
        }
        binding.btn2PuntosLocal.setOnClickListener {
            localPoint += 2
            setPointLocal()
        }
        binding.btn3PuntosLocal.setOnClickListener {
            localPoint += 3
            setPointLocal()
        }
    }

    private fun initListenerVisit() {
        binding.floatingRemoveVisitante.setOnClickListener {
            visitPoint -= 1
            setPointVist()
        }
        binding.floatingAddVisitante.setOnClickListener {
            visitPoint += 1
            setPointVist()
        }
        binding.btn1PuntoVisita.setOnClickListener {
            visitPoint += 1
            setPointVist()
        }
        binding.btn2PuntosVisita.setOnClickListener {
            visitPoint += 2
            setPointVist()
        }
        binding.btn3PuntosVisita.setOnClickListener {
            visitPoint += 3
            setPointVist()
        }
    }

    private fun setPointLocal() {
        binding.tvResultadoLocal.text = localPoint.toString()


    }

    private fun setPointVist() {
        binding.tvResultadoVisitante.text = visitPoint.toString()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAudit().apply {
                arguments = Bundle().apply {

                }
            }
    }
}