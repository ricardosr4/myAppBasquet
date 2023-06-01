package com.example.myappbasquet.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentLoginRegisterBinding


class LoginRegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentLoginRegisterBinding

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
        binding = FragmentLoginRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginRegisterFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}