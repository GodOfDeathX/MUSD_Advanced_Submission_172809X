package com.example.dylansim.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import com.example.dylansim.movierater.Movie

class Main2Activity : AppCompatActivity() {
    var movie = Movie()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        detailTitle.text = movie.movieEntityName
        detailDescription.text = movie.movieEntityDescription
        detailLanguage.text = movie.movieEntityLanguage
        detailReleaseDate.text = movie.movieEntityReleaseDate
        detailSuitability.text = movie.movieEntitySuitability
    }
}
