package com.example.smartdays

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        // Configuración del Spinner
        val intensitySpinner: Spinner = findViewById(R.id.intensity_spinner)
        val intensityOptions = arrayOf("Baja", "Media", "Alta") // Opciones del Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, intensityOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        intensitySpinner.adapter = spinnerAdapter



        // Configuración de RatingBar
        val ratingBar: RatingBar = findViewById(R.id.rating_bar)
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Calificación: $rating", Toast.LENGTH_SHORT).show()
        }

        // Configuración de CheckBox
        val recommendCheckBox: CheckBox = findViewById(R.id.recommend_checkbox)
        recommendCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Recomendarías esta app", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No recomendarías esta app", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del RadioGroup
        val ageRadioGroup: RadioGroup = findViewById(R.id.age_radio_group)
        ageRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton: RadioButton = findViewById(checkedId)
            Toast.makeText(this, "Edad seleccionada: ${selectedRadioButton.text}", Toast.LENGTH_SHORT).show()
        }

        // Configuración del AlertDialog
        val alertDialogButton: Button = findViewById(R.id.alert_dialog_button)
        alertDialogButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Estás seguro de que deseas enviar?")
                .setPositiveButton("Sí") { dialog, _ ->
                    Toast.makeText(this, "Enviado", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ ->
                    Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .create()
            alertDialog.show()
        }

        // Configuración del TimePickerDialog
        val timePickerButton: Button = findViewById(R.id.time_picker_button)
        timePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    Toast.makeText(this, "Hora seleccionada: $hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        }

        // Configuración del DatePickerDialog
        val datePickerButton: Button = findViewById(R.id.date_picker_button)
        datePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    Toast.makeText(this, "Fecha seleccionada: $dayOfMonth/${month + 1}/$year", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
    }
}
