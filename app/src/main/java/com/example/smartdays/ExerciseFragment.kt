package com.example.smartdays

import Exercise
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExerciseFragment : Fragment(R.layout.fragment_exercise) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var exercises: List<Exercise>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Enlazar RecyclerView
        recyclerView = view.findViewById(R.id.exercise_recycler_view)

        // Inicializar la lista de ejercicios
        val exercises = listOf(
            Exercise("Flexiones", "Baja", "10 minutos", "Baja"),
            Exercise("Sentadillas", "Baja", "15 minutos", "Media"),
            Exercise("Plancha", "Baja", "5 minutos", "Alta")
        )


        // Configurar el adaptador
        exerciseAdapter = ExerciseAdapter(exercises)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = exerciseAdapter
    }
}
