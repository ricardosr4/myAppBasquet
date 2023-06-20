package com.example.myappbasquet.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentLoginStartBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern


class LoginStartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentLoginStartBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginStartBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivback.setOnClickListener {
            findNavController().navigate(R.id.action_loginStartFragment2_to_loginStepOneFragment)
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginStartFragment2_to_forgotPasswordFragment)
        }
        binding.irRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginStartFragment2_to_loginRegisterFragment2)
        }

        binding.btnAcceso.setOnClickListener {
            findNavController().navigate(R.id.action_loginStartFragment2_to_fragmentHome)

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(context, "por favor complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "registro exitoso", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(
                        context,
                        "error al registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginStartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}