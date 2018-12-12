package com.example.dylansim.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkboxNotSuitable.setOnClickListener(View.OnClickListener {
            if (checkboxNotSuitable.isChecked == true) {
                checkboxLayout.visibility = View.VISIBLE
            }
            if (checkboxNotSuitable.isChecked == false) {
                checkboxLayout.visibility = View.GONE
            }
        })
        addMovie.setOnClickListener {
            var counter = 0
            val lang = findViewById<RadioButton>(languageRadioGroup.checkedRadioButtonId).text
            val suitable = checkboxNotSuitable.isChecked
            var violenceCheck = ""
            var languageCheck = ""
            if (violence.isChecked && languageUsed.isChecked) {
                violenceCheck = "${violence.text}"
                languageCheck = "${languageUsed.text}"
            } else if (languageUsed.isChecked) {
                languageCheck = "${languageUsed.text}"
            } else if (violence.isChecked) {
                violenceCheck = "${violence.text}"
            }
            if (movieName.text.isEmpty()) {
                movieName.error = "Field Empty"
                counter++
            }
            if (movieDescription.text.isEmpty()) {
                movieDescription.error = "Field Empty"
                counter++
            }
            if (movieReleaseDate.text.isEmpty()) {
                movieReleaseDate.error = "Field Empty"
                counter++
            }
            if (counter == 0) Toast.makeText(
                this,
                "title = ${movieName.text} \n Overview = ${movieDescription.text} \n Release Date ${movieReleaseDate.text} \n Language = $lang \n Suitable for all ages = $suitable \n Reason: \n $violenceCheck \n $languageCheck",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

