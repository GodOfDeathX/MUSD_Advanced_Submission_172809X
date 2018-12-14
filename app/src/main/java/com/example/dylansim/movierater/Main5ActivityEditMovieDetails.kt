package com.example.dylansim.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class Main5ActivityEditMovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5_edit_movie_details)

        checkboxNotSuitable.setOnClickListener(View.OnClickListener {
            if (checkboxNotSuitable.isChecked == true) {
                checkboxLayout.visibility = View.VISIBLE
            }
            if (checkboxNotSuitable.isChecked == false) {
                checkboxLayout.visibility = View.GONE
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editmoviemenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
