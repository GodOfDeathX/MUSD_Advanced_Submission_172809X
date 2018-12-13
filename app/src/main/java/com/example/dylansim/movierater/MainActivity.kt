package com.example.dylansim.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        val actionBar = supportActionBar

        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addmoviemenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var myIntent = Intent(this, MainActivity::class.java)

        if(item?.itemId == R.id.menuAdd) {

            var validate = true
            if(movieName.text.isEmpty()) {
                validate = false
                movieName.error = "Field empty"
            }
            if(movieDescription.text.isEmpty()) {
                validate = false
                movieDescription.error = "Field empty"
            }
            if(movieReleaseDate.text.isEmpty()) {
                validate = false
                movieReleaseDate.error = "Field empty"
            }
            if(validate) {
                myIntent.putExtra("title", movieName.text.toString())
                myIntent.putExtra("description", movieDescription.text.toString())
                var language = ""
                if (english.isChecked) {
                    language = "English"
                } else if (chinese.isChecked) {
                    language = "Chinese"
                } else if (malay.isChecked) {
                    language = "Malay"
                } else if (tamil.isChecked) {
                    language = "Tamil"
                }
                myIntent.putExtra("language", language)
                myIntent.putExtra("releaseDate", movieReleaseDate.text.toString())
                myIntent.putExtra("suitable", checkboxNotSuitable.isChecked)
                myIntent.putExtra("violence", violence.isChecked)
                myIntent.putExtra("languageUsed", languageUsed.isChecked)
                startActivity(myIntent)
                finish()
            }
        }
        else if (item?.itemId == R.id.menuClearEntries) {
            movieName.setText("")
            movieDescription.setText("")
            movieReleaseDate.setText("")
            english.isChecked = false
            chinese.isChecked = false
            malay.isChecked = false
            tamil.isChecked = false
            checkboxNotSuitable.isChecked = false
            violence.isChecked = false
            languageUsed.isChecked = false
            violence.visibility = View.GONE
            languageUsed.visibility = View.GONE
        }


        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()

        return super.onSupportNavigateUp()
    }
}

