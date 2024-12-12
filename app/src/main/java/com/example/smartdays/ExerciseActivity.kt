package com.example.smartdays

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExerciseActivity : AppCompatActivity() {

    private lateinit var exerciseContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val addExerciseButton: Button = findViewById(R.id.add_exercise_button)
        val finishButton: Button = findViewById(R.id.finish_button)
        exerciseContainer = findViewById(R.id.exercise_list_container)

        addExerciseButton.setOnClickListener {
            showAddExerciseDialog()
        }

        finishButton.setOnClickListener {
            val intent = Intent(this, FinishActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showAddExerciseDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_exercise)

        val exerciseNameInput: EditText = dialog.findViewById(R.id.exercise_name_input)
        val intensityInput: EditText = dialog.findViewById(R.id.intensity_input)
        val muscleInput: EditText = dialog.findViewById(R.id.muscle_input)
        val addButton: Button = dialog.findViewById(R.id.add_exercise_button)

        addButton.setOnClickListener {
            val exerciseName = exerciseNameInput.text.toString().trim()
            val intensity = intensityInput.text.toString().trim()
            val muscle = muscleInput.text.toString().trim()

            if (exerciseName.isEmpty() || intensity.isEmpty() || muscle.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                addExercise(exerciseName, intensity, muscle)
                dialog.dismiss()
            }
        }

        dialog.show()
    }

    private fun addExercise(name: String, intensity: String, muscle: String) {
        val exerciseView = LayoutInflater.from(this).inflate(R.layout.exercise_item, exerciseContainer, false)

        val exerciseNameText: TextView = exerciseView.findViewById(R.id.exercise_name)
        val exerciseDetailsText: TextView = exerciseView.findViewById(R.id.exercise_details)
        val removeButton: Button = exerciseView.findViewById(R.id.remove_button)

        exerciseNameText.text = name
        exerciseDetailsText.text = "Intensidad: $intensity | Músculo: $muscle"

        removeButton.setOnClickListener {
            exerciseContainer.removeView(exerciseView)
            Toast.makeText(this, "Ejercicio eliminado", Toast.LENGTH_SHORT).show()
        }

        exerciseContainer.addView(exerciseView)
    }
}
