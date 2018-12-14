package com.example.dylansim.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
import com.example.dylansim.movierater.Movie

class Main2Activity : AppCompatActivity() {
    val MAIN_ACTIVITY_VIEW_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var titleFromAdd = intent.getStringExtra("title")
        var descriptionFromAdd = intent.getStringExtra("description")
        var languageFromAdd = intent.getStringExtra("language")
        var releaseDateFromAdd = intent.getStringExtra("releaseDate")
        var suitableFromAdd = intent.getBooleanExtra("suitable", false)
        var violenceFromAdd = intent.getBooleanExtra("violence", false)
        var languageUsedFromAdd = intent.getBooleanExtra("languageUsed", false)

        val movie = Movie(titleFromAdd, descriptionFromAdd, releaseDateFromAdd, languageFromAdd, suitableFromAdd, violenceFromAdd, languageUsedFromAdd)

        detailTitle.text = movie.title
        detailDescription.text = movie.description
        detailLanguage.text = movie.language
        detailReleaseDate.text = movie.releaseDate

        var suitability = ""
        if(movie.suitable) {
            if(movie.violence && movie.languageUsed) {
                suitability = "No (Violence, Language Used)"
            }
            else if(movie.violence) {
                suitability = "No (Violence)"
            }
            else if(movie.languageUsed) {
                suitability = "No (Language Used)"
            }
            else {
                suitability = "No"
            }
        }
        else {
            suitability = "Yes"
        }


        detailSuitability.text = suitability



        val actionBar = supportActionBar

        actionBar!!.setDisplayHomeAsUpEnabled(true)

        registerForContextMenu(detailReview)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(1, 1001, 1, "Add Review")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            var myIntent = Intent(this, Main3Activity::class.java)
            myIntent.putExtra("title", intent.getStringExtra("title"))
            startActivityForResult(myIntent, MAIN_ACTIVITY_VIEW_REQUEST_CODE)
        }

        return super.onContextItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return super.onSupportNavigateUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == MAIN_ACTIVITY_VIEW_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                var reviewMsg = data?.getStringExtra("message") as String
                var reviewRating = data?.getFloatExtra("rating", 0f)
                ratingBar.visibility = View.VISIBLE
                ratingBar.rating = reviewRating
                detailReview.text = reviewMsg
                unregisterForContextMenu(detailReview)
            }
        }
    }
}

class Movie(Title: String, Description: String, ReleaseDate: String, Language: String, Suitable: Boolean, Violence: Boolean, LanguageUsed: Boolean)  {
    var title: String
    var description: String
    var releaseDate: String
    var language: String
    var suitable: Boolean
    var violence: Boolean
    var languageUsed: Boolean

    init {
        this.title = Title
        this.description = Description
        this.releaseDate = ReleaseDate
        this.language = Language
        this.suitable = Suitable
        this.violence = Violence
        this.languageUsed = LanguageUsed
    }


}