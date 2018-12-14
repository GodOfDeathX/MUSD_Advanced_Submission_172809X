package com.example.dylansim.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        registerForContextMenu(long_press_movie)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(1,1001,1,"Add")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            var myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        return super.onContextItemSelected(item)
    }
}
