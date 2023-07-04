package com.example.myappbasquet.data.remote.firestore

import com.example.myappbasquet.data.remote.constant.ConstantFirestore.AMISTOSOS
import com.example.myappbasquet.data.remote.constant.ConstantFirestore.USUARIOS
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


class MatchesRemoteFire @Inject constructor() {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val listMatches = mutableListOf<MatchesEntry>()

    // esta funcion es para obtener los partidos de un usuario
    suspend fun getMatchesFire(user_name: String): List<MatchesEntry> {
        listMatches.clear()
        val docRefMatches = db.collection(USUARIOS).document(user_name).collection(AMISTOSOS)
        docRefMatches.get().addOnSuccessListener { document ->
            document.forEach {
                listMatches.add(
                    MatchesEntry(
                        fechajuego = it.id,
                        resultado = it.getString("resultado").toString(),
                        equipo_local = it.getString("equipo_local").toString(),
                        equipo_visitante = it.getString("equipo_visitante").toString(),
                    )
                )
            }
        }.await()
        return listMatches
    }
}