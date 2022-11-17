package net.androidbootcamp.jumpbagplus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    // store input from PSI and LPM text boxes
    private lateinit var psi : EditText
    private lateinit var lpm : EditText
    internal lateinit var btnSwitch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // store switch choice
        var reserveOx = 200
        //access data from Strings.xml array
        val tanks = resources.getStringArray(R.array.tankSizeArray)
        //create button
        val calcBtn = findViewById<Button>(R.id.btn_calculate)
        //create variable to store data from spinner
        var spinnerResult = ""
        //access the spinner
        val spinner = findViewById<Spinner>(R.id.spTankSize)
        //access textView for result
        val resultText = findViewById<TextView>(R.id.txt_solution)

        //check the spinner
        if (spinner != null) {
            //create adapter for spinner
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tanks)
            spinner.adapter = adapter

            //accessing spinner item selection listener
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    //storing spinner selection for use in button algorithm
                    spinnerResult = tanks[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // This function is intentionally empty because the spinner always has a selection
                }

            }

        }

        //create switch listener
        btnSwitch = findViewById(R.id.reserveOxSwitch)
        btnSwitch.setOnClickListener {
            reserveOx = if (btnSwitch.isChecked) {
                500
            } else {
                200
            }
        }



        //create button click listener
        calcBtn.setOnClickListener {

            psi = findViewById(R.id.text_input_PSI)
            lpm = findViewById(R.id.text_input_LPM)
            val psiInt = psi.text
            val lpmInt = lpm.text
            var timeRemaining = 0f
            var conversionRate = 0f
            var cylinderPressure = 0f
            var flowRate = 0f

            //check to make sure psi and lpm are not null and are integers
            if (psiInt.isEmpty()) {
                Toast.makeText(this, "Please enter a PSI.", Toast.LENGTH_SHORT).show()
            } else if (lpmInt.isEmpty()) {
                    Toast.makeText(this, "Please enter a LPM.", Toast.LENGTH_SHORT).show()
                } else {
                    try {
                        //switch statement for oxygen algorithm
                        when (spinnerResult) {
                            "D cylinder" -> {
                                // (Current Cylinder Pressure × Conversion factor) /Flow (L/min) =
                                // Duration of flow (min).
                                conversionRate = 0.16f
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                flowRate = lpmInt.toString().toFloat()
                                cylinderPressure = cylinderPressure * conversionRate
                                timeRemaining = cylinderPressure / flowRate

                                resultText.setVisibility(View.VISIBLE)
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")


                            }
                            "E cylinder" -> {
                                // (Current Cylinder Pressure × Conversion factor) /Flow (L/min) =
                                // Duration of flow (min).
                                conversionRate = 0.28f
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                flowRate = lpmInt.toString().toFloat()
                                cylinderPressure = cylinderPressure * conversionRate
                                timeRemaining = cylinderPressure / flowRate

                                resultText.setVisibility(View.VISIBLE)
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                            }
                            "M cylinder" -> {
                                // (Current Cylinder Pressure × Conversion factor) /Flow (L/min) =
                                // Duration of flow (min).
                                conversionRate = 1.56f
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                flowRate = lpmInt.toString().toFloat()
                                cylinderPressure = cylinderPressure * conversionRate
                                timeRemaining = cylinderPressure / flowRate

                                resultText.setVisibility(View.VISIBLE)
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                            }
                            "G cylinder" -> {
                                // (Current Cylinder Pressure × Conversion factor) /Flow (L/min) =
                                // Duration of flow (min).
                                conversionRate = 2.41f
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                flowRate = lpmInt.toString().toFloat()
                                cylinderPressure = cylinderPressure * conversionRate
                                timeRemaining = cylinderPressure / flowRate

                                resultText.setVisibility(View.VISIBLE)
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                            }
                            "H/K cylinder" -> {
                                // (Current Cylinder Pressure × Conversion factor) /Flow (L/min) =
                                // Duration of flow (min).
                                conversionRate = 3.14f
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                flowRate = lpmInt.toString().toFloat()
                                cylinderPressure = cylinderPressure * conversionRate
                                timeRemaining = cylinderPressure / flowRate

                                resultText.setVisibility(View.VISIBLE)
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                            }
                            else -> {
                                Toast.makeText(this,"No tank size was selected.",Toast.LENGTH_SHORT).show()
                            }
                        }
                    } catch (e: NumberFormatException) {Toast.makeText(this,"Please enter a valid number for PSI.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}



