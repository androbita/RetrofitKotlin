package com.example.retrofitexamplekotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexamplekotlin.databinding.RowItemBinding
import com.example.retrofitexamplekotlin.model.ResultUsers

class UsersAdapter(val data: List<ResultUsers>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get:ResultUsers?){
            binding.nama.text = get?.name
            binding.email.text = get?.email
            binding.notelp.text = get?.phone

            val address = "${get?.address?.street}, ${get?.address?.suite}, ${get?.address?.city}, ${get?.address?.zipcode}"

            binding.alamat.text = address
        }

    }
}