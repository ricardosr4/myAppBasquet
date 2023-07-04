package com.example.myappbasquet.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myappbasquet.R
import com.example.myappbasquet.databinding.FragmentLoginStepOneBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginStepOneFragment : Fragment() {
    private lateinit var binding: FragmentLoginStepOneBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    private val dataStoreViewModel by viewModels<DataStoreViewModel>()
    private lateinit var auth: FirebaseAuth
    private var loginActive :String =""
    private var loginActiveGoogle :String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginStepOneBinding.inflate(inflater, container, false)
        return  binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            loginActive = dataStoreViewModel.getLoginActive()
            loginActiveGoogle = dataStoreViewModel.getLoginActiveGoogle()
        }

        if (loginActive == "active" || loginActiveGoogle == "active_google"){
            findNavController().navigate(R.id.action_global_fragmentHome)
        }

        binding.buttongoogle.setOnClickListener {
            findNavController().navigate(R.id.action_loginStepOneFragment_to_fragmentHome)
        }
        binding.buttonemail.setOnClickListener {
            findNavController().navigate(R.id.action_loginStepOneFragment_to_loginRegisterFragment)
        }
        binding.txtbuttonlogin.setOnClickListener {
           findNavController().navigate(R.id.action_loginStepOneFragment_to_loginStartFragment2)
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        binding.buttongoogle.setOnClickListener {
            signInWithGoogle()
        }

    }


    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 123)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account?.idToken)
            } catch (e: ApiException) {
                Toast.makeText(requireContext(), "error$e",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    saveValueSession("active_google")
                    findNavController().navigate(R.id.action_loginStepOneFragment_to_fragmentHome)
                } else {
                    saveValueSession("inactive_google")
                    Toast.makeText(requireContext(), "error",Toast.LENGTH_SHORT).show()
                    // Manejar el error de inicio de sesión con Google
                }
            }
    }

    private  fun saveValueSession(valueLogin:String) {
        dataStoreViewModel.storeLoginActiveGoogle(valueLogin)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginStepOneFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}