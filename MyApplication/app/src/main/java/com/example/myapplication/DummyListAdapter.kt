package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ListLayoutBinding

class DummyListAdapter:  RecyclerView.Adapter<DummyListAdapter.ViewHolder>() {
    private var dataList = ArrayList<Product>()

    fun setDataList(movieList : List<Product>){
        this.dataList = movieList as ArrayList<Product>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ListLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(dataList[position].thumbnail)
            .into(holder.binding.productImage)
        holder.binding.productName.text = dataList[position].title
        holder.binding.productPrice.text = dataList[position].price.toString()
        holder.binding.productRating.text = dataList[position].rating.toString()
        holder.binding.productStock.text = dataList[position].stock.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}