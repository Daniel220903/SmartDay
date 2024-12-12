package com.example.smartdays

import Exercise
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exercises: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.nameTextView.text = exercise.name
        holder.difficultyTextView.text = exercise.difficulty
        holder.durationTextView.text = exercise.duration
        holder.intensityTextView.text = exercise.intensity
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.exercise_name)
        val difficultyTextView: TextView = itemView.findViewById(R.id.exercise_difficulty)
        val durationTextView: TextView = itemView.findViewById(R.id.exercise_duration)
        val intensityTextView: TextView = itemView.findViewById(R.id.exercise_intensity)
    }
}
