package com.example.myappbasquet.ui.fragment.login

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentLoginRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class LoginRegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentLoginRegisterBinding
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
        binding = FragmentLoginRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivback.setOnClickListener {
            findNavController().navigate(R.id.action_loginRegisterFragment_to_loginStepOneFragment)
        }
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.ir_login)
        }
        binding.btnRegister.setOnClickListener {

            if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString()
                    .isNotEmpty()
            ) {
                registerUser(binding.etEmail.text.toString(), binding.etPassword.text.toString())
                isValidEmail(binding.etEmail.text.toString())
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
                    findNavController().navigate(R.id.action_loginRegisterFragment_to_loginStartFragment2)
                    Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    // Registro exitoso, redirigir a la siguiente actividad o realizar otras acciones necesarias
                } else {
                    Toast.makeText(
                        context,
                        "Error al registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    //todo esta funcion sirve para validar que sea un correo electronico valido.
    private fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
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