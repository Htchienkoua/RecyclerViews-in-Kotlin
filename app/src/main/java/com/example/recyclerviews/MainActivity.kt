package com.example.recyclerviews

//the android recycler view is more advanced verision of a ListView with improved performance and benefits
//RecyclerViews can take positions horizontally and vertically

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    //three arrays for the recycler view will be the country name, country details , and the country flag as an image
    //remember that images in an array are stored as Int, not Strings
    var countryNameList = ArrayList<String>()
    var detailsList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    lateinit var adapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        //
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        countryNameList.add("United Kingdom")
        countryNameList.add("Germany")
        countryNameList.add("United States of America")

        detailsList.add("This is the United Kingdom Flag")
        detailsList.add("This is the German Flag")
        detailsList.add("This is the United States of America Flag")

        imageList.add(R.drawable.britain)
        imageList.add(R.drawable.germany)
        imageList.add(R.drawable.usa)

        adapter = CountriesAdapter(countryNameList, detailsList, imageList, this@MainActivity)

        recyclerView.adapter = adapter
    }
}