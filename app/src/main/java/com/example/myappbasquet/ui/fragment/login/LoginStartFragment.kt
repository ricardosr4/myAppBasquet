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
            //  todo esto esta mal aqui debe de ir despues de que se registre y se valide el correo y contraseña
            // todo ejemplo deberia de estar dentro de la funcion registeruser despues de recibir el task.issuccessful en vez de tener el toast debe de estar el fin navControler
            //  todo de la manera que tienes esto que causa que te envie al login antes de registrar al usuario si presionas el boton registrar sin llenar los campos te manda igual al login jajaj

            findNavController().navigate(R.id.action_loginStartFragment2_to_fragmentHome)

            // todo estos campos podrian ir directamente en el if asi mira
            // todo  if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString().isNotEmpty()) , asi evitas 2 lineas de codigo que no son necesarias y se ve mas limpio y es lo mismo
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