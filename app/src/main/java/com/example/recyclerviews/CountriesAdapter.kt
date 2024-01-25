package com.example.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(
    var countryNameList: ArrayList<String>,
    var detailsList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>(){

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewCountryName : TextView = itemView.findViewById(R.id.textViewCountryName)
        var textViewDetails : TextView = itemView.findViewById(R.id.textViewDetail)
        var imageView: ImageView = itemView.findViewById(R.id.profile_image)

        var cardView : CardView = itemView.findViewById(R.id.cardView)
    }

    //create sthe View for showing the recycler view previously created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)

        return CountryViewHolder(view)
        }

    // this method specifies the amount of data to be shown to the recycler view(i.e number of recycler view items)
    override fun getItemCount(): Int {

        return countryNameList.size //since we can't know the exact size of the items
        //this is especially important for large databases and apps needing internet 'get' methods
    }


    //this method specifies the data to show on the screen by binding it to the adapter
    //to make the items of the recycler view clickable , we need to define it in this method
    //since it binds the recycler components together in the View holder
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewDetails.text = detailsList.get(position)
        holder.imageView.setImageResource(imageList.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context,
                "You selected the ${countryNameList.get(position)}",
                Toast.LENGTH_LONG ).show()
        }
    }

}