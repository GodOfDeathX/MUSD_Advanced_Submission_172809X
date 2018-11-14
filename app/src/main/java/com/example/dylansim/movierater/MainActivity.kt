package com.example.dylansim.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkboxNotSuitable.setOnClickListener(View.OnClickListener {
            if (checkboxNotSuitable.isChecked == true){
                checkboxLayout.setVisibility(View.VISIBLE);
            }
        })
    }
}
