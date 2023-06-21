package com.example.myappbasquet.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class ForgotPasswordFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentForgotPasswordBinding
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
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivback.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginStartFragment2)
        }
        binding.btnForgotPassword.setOnClickListener {
            if (binding.etForgotPassword.text.toString().isNotEmpty()){
                resetPassword(binding.etForgotPassword.text.toString())
            }
        }
    }
    private fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "se envio un correo para restablecer la contraseña", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "no se pudo enviar el correo para restablecer la contraseña", Toast.LENGTH_SHORT).show()

            }
        }
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForgotPasswordFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}