package net.androidbootcamp.jumpbagplus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    private lateinit var psi : EditText
    private lateinit var lpm : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access items from Strings.xml array
        val tanks = resources.getStringArray(R.array.tankSizeArray)
        // access input for PSI
        //var psi : EditText? = null
        // access input for LPM
        //var lpm : EditText? = null
        //create button
        val calcBtn = findViewById<Button>(R.id.btn_calculate)
        //create variable to store data from spinner
        var spinnerResult = ""
        //access the spinner
        val spinner = findViewById<Spinner>(R.id.spTankSize)

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
                    TODO("Not yet implemented")
                }

            }

        }

        //create button click listener
        calcBtn.setOnClickListener {

            //check that spinner data is being stored for use
            //Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()

            psi = findViewById(R.id.text_input_PSI)
            lpm = findViewById(R.id.text_input_LPM)

            //check to make sure psi is not null before performing calculation
            if (psi.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a PSI.", Toast.LENGTH_SHORT).show()
            } else {
                //check to make sure lpm is not null
                if (lpm.text.toString().isEmpty()) {
                    Toast.makeText(this, "Please enter a LPM.", Toast.LENGTH_SHORT).show()
                } else {
                    //switch statement for oxygen algorithm
                    when (spinnerResult) {
                        "D cylinder" -> {
                            Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()
                        }
                        "E cylinder" -> {
                            Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()
                        }
                        "M cylinder" -> {
                            Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()
                        }
                        "G cylinder" -> {
                            Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()
                        }
                        "H/K cylinder" -> {
                            Toast.makeText(this, spinnerResult, Toast.LENGTH_SHORT).show()
                        } else -> {
                            Toast.makeText(this, "No tank size was selected.", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }
            }
        }
    }
}


