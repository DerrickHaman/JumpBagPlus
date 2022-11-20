/* JumpBagPlus is an Android application built using Kotlin and Android Studio.
* The purpose of this application is to provide one application that contains
* various tools for healthcare providers. The first version is an oxygen calculator.
* Later versions will include additional tools like a medication infusion calculator
* and routing to the closest hospital. The second purpose to this app, is to allow me
* to learn continuous development and deployment on the Android platform.
*
* Author: Derrick Haman
* */
package net.androidbootcamp.jumpbagplus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    // declaring variables for EditText and Switch
    private lateinit var psi : EditText
    private lateinit var lpm : EditText
    internal lateinit var btnSwitch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // store and set default Switch choice
        var reserveOx = 200
        //access data from Strings.xml array
        val tanks = resources.getStringArray(R.array.tankSizeArray)
        //create variable to store data from spinner
        var spinnerResult = ""
        //access the spinner
        val spinner = findViewById<Spinner>(R.id.spTankSize)
        //access textView for result
        val resultText = findViewById<TextView>(R.id.txt_solution)
        //access button
        val calcBtn = findViewById<Button>(R.id.btn_calculate)

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

        //create Switch listener
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

            // using previously declared EditText
            psi = findViewById(R.id.text_input_PSI)
            lpm = findViewById(R.id.text_input_LPM)

            // Declaring variables to store EditText user input
            val psiInt = psi.text
            val lpmInt = lpm.text

            // Declaring variables to be used in  oxygen calculation
            var timeRemaining = 0f
            var conversionRate = 0f
            var cylinderPressure = 0f
            var flowRate = 0f

            //check to make sure psi and lpm are not null, format does not have to be verified as NumText elements are being used instead of EditText elements
            if (psiInt.isEmpty()) {
                Toast.makeText(this, "Please enter a PSI.", Toast.LENGTH_SHORT).show()
            } else if (lpmInt.isEmpty()) {
                    Toast.makeText(this, "Please enter a LPM.", Toast.LENGTH_SHORT).show()
                } else {
                    // Try catch statement to perform oxygen calculation
                    try {
                        //switch statement for oxygen calculation, using spinner selection to change cylinder size
                        when (spinnerResult) {
                            "D cylinder" -> {
                                // ((Current Cylinder Pressure - Reserve Oxygen Supply)× Conversion Rate Factor) /Flow Rate = Minutes of Oxygen Remaining.
                                // accessing variable for conversion rate of tank
                                conversionRate = 0.16f
                                // Storing user input and performing first step in calculation  and storing in cylinderPressure variable : (Current Cylinder Pressure - Reserve Oxygen Supply = Cylinder Pressure)
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                // Performing second step of calculation : (Cylinder Pressure * Conversion Rate Factor = Cylinder Pressure)
                                cylinderPressure *= conversionRate
                                // Storing user input from Liters Per Minute(LPM) EditText
                                flowRate = lpmInt.toString().toFloat()
                                // Performing final step in calculation : (Cylinder Pressure Result / FlowRate = Time Remaining in Minutes)
                                timeRemaining = cylinderPressure / flowRate

                                // Making TextView element visible and populating result to the TextView element
                                resultText.visibility = View.VISIBLE
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                                // Clearing user input so the app can be run again with new input.
                                psi.text.clear()
                                lpm.text.clear()


                            }
                            "E cylinder" -> {
                                // ((Current Cylinder Pressure - Reserve Oxygen Supply)× Conversion Rate Factor) /Flow Rate = Minutes of Oxygen Remaining.
                                // accessing variable for conversion rate of tank
                                conversionRate = 0.28f
                                // Storing user input and performing first step in calculation  and storing in cylinderPressure variable : (Current Cylinder Pressure - Reserve Oxygen Supply = Cylinder Pressure)
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                // Performing second step of calculation : (Cylinder Pressure * Conversion Rate Factor = Cylinder Pressure)
                                cylinderPressure *= conversionRate
                                // Storing user input from Liters Per Minute(LPM) EditText
                                flowRate = lpmInt.toString().toFloat()
                                // Performing final step in calculation : (Cylinder Pressure Result / FlowRate = Time Remaining in Minutes)
                                timeRemaining = cylinderPressure / flowRate

                                // Making TextView element visible and populating result to the TextView element
                                resultText.visibility = View.VISIBLE
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                                // Clearing user input so the app can be run again with new input.
                                psi.text.clear()
                                lpm.text.clear()

                            }
                            "M cylinder" -> {
                                // ((Current Cylinder Pressure - Reserve Oxygen Supply)× Conversion Rate Factor) /Flow Rate = Minutes of Oxygen Remaining.
                                // accessing variable for conversion rate of tank
                                conversionRate = 1.56f
                                // Storing user input and performing first step in calculation  and storing in cylinderPressure variable : (Current Cylinder Pressure - Reserve Oxygen Supply = Cylinder Pressure)
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                // Performing second step of calculation : (Cylinder Pressure * Conversion Rate Factor = Cylinder Pressure)
                                cylinderPressure *= conversionRate
                                // Storing user input from Liters Per Minute(LPM) EditText
                                flowRate = lpmInt.toString().toFloat()
                                // Performing final step in calculation : (Cylinder Pressure Result / FlowRate = Time Remaining in Minutes)
                                timeRemaining = cylinderPressure / flowRate

                                // Making TextView element visible and populating result to the TextView element
                                resultText.visibility = View.VISIBLE
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                                // Clearing user input so the app can be run again with new input.
                                psi.text.clear()
                                lpm.text.clear()

                            }
                            "G cylinder" -> {
                                // ((Current Cylinder Pressure - Reserve Oxygen Supply)× Conversion Rate Factor) /Flow Rate = Minutes of Oxygen Remaining.
                                // accessing variable for conversion rate of tank
                                conversionRate = 2.41f
                                // Storing user input and performing first step in calculation  and storing in cylinderPressure variable : (Current Cylinder Pressure - Reserve Oxygen Supply = Cylinder Pressure)
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                // Performing second step of calculation : (Cylinder Pressure * Conversion Rate Factor = Cylinder Pressure)
                                cylinderPressure *= conversionRate
                                // Storing user input from Liters Per Minute(LPM) EditText
                                flowRate = lpmInt.toString().toFloat()
                                // Performing final step in calculation : (Cylinder Pressure Result / FlowRate = Time Remaining in Minutes)
                                timeRemaining = cylinderPressure / flowRate

                                // Making TextView element visible and populating result to the TextView element
                                resultText.visibility = View.VISIBLE
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                                // Clearing user input so the app can be run again with new input.
                                psi.text.clear()
                                lpm.text.clear()

                            }
                            "H/K cylinder" -> {
                                // ((Current Cylinder Pressure - Reserve Oxygen Supply)× Conversion Rate Factor) /Flow Rate = Minutes of Oxygen Remaining.
                                // accessing variable for conversion rate of tank
                                conversionRate = 3.14f
                                // Storing user input and performing first step in calculation  and storing in cylinderPressure variable : (Current Cylinder Pressure - Reserve Oxygen Supply = Cylinder Pressure)
                                cylinderPressure = psiInt.toString().toFloat() - reserveOx
                                // Performing second step of calculation : (Cylinder Pressure * Conversion Rate Factor = Cylinder Pressure)
                                cylinderPressure *= conversionRate
                                // Storing user input from Liters Per Minute(LPM) EditText
                                flowRate = lpmInt.toString().toFloat()
                                // Performing final step in calculation : (Cylinder Pressure Result / FlowRate = Time Remaining in Minutes)
                                timeRemaining = cylinderPressure / flowRate

                                // Making TextView element visible and populating result to the TextView element
                                resultText.visibility = View.VISIBLE
                                resultText.setText("You have " + timeRemaining.toInt().toString() + " minutes remaining.")

                                // Clearing user input so the app can be run again with new input.
                                psi.text.clear()
                                lpm.text.clear()

                            }
                            else -> {
                                // Default toast message to advise the user to make a spinner selection just in case the spinner does not populate the first array element
                                Toast.makeText(this,"No tank size was selected.",Toast.LENGTH_SHORT).show()
                            }
                        }
                    } catch (e: NumberFormatException) {
                        // Toast message to notify the user that more input is required.
                        Toast.makeText(this,"Please enter a valid number for PSI and LPM.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}



