package com.myapp.carrating

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var carRating: CarRating
    private lateinit var vehicleMakeEditText: EditText
   private lateinit var vehicleModelEditText: EditText
   private lateinit var fuelTypeSpinner: Spinner
   private lateinit var manualTransmissionRadioButton: RadioButton
   private lateinit var automaticTransmissionRadioButton: RadioButton
   private lateinit var ratingBar: RatingBar
   private lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carRating = CarRating()

        vehicleMakeEditText = findViewById(R.id.make_edit_text)
        vehicleMakeEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //no op
            }

            override fun onTextChanged(seq: CharSequence?, start: Int, count: Int, after: Int) {
                carRating.vehcileMake = seq.toString()
                Log.d(TAG, "update make name to " +seq.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // no op
            }
        })


        vehicleModelEditText = findViewById(R.id.model_edit_text)
        vehicleModelEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //no op
            }

            override fun onTextChanged(seq: CharSequence?, start: Int, count: Int, after: Int) {
                carRating.vehicleModel = seq.toString()
                Log.d(TAG, "update model name to " +seq.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // no op
            }
        })

        fuelTypeSpinner = findViewById(R.id.spinner)
        fuelTypeSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               val fuelType = parent?.getItemAtPosition(position) as String
                carRating.fuelType = fuelType
                Log.d(TAG, "fuel type : $fuelType")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // do nothing
            }
        }
        manualTransmissionRadioButton = findViewById(R.id.radioButton)

        automaticTransmissionRadioButton = findViewById(R.id.radioButton2)



        ratingBar = findViewById(R.id.ratingBar)
        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ parent,rating, fromUser ->
                carRating.rating = rating.toInt()
                Log.d(TAG, "rating $rating")

        }
        submitButton = findViewById(R.id.submit_button)
    }
    fun onSubmitButtonClick(view: View) {
        Toast.makeText(
            applicationContext,
            carRating.toString(),
            Toast.LENGTH_SHORT).show();
    }
}