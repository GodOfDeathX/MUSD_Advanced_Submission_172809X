package com.example.dylansim.movierater

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var titleFromReview = intent.getStringExtra("title")

        ReviewTitle.text = "${ReviewTitle.text}" + titleFromReview

        val actionBar = supportActionBar

        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.submitreviewmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.menuSubmit) {
            var output = Intent()
            output.putExtra("message", ReviewEditText.text.toString())
            output.putExtra("rating", ReviewRatingBar.rating)
            setResult(Activity.RESULT_OK, output)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

