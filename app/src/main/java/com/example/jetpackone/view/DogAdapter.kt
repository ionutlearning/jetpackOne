package com.example.jetpackone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackone.R
import com.example.jetpackone.model.DogBreed
import kotlinx.android.synthetic.main.dog_item.view.*

class DogAdapter(private val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dog_item, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogsList[position]
        holder.view.name.text = dog.dogBreed
        holder.view.lifespan.text = dog.lifeSpan
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}