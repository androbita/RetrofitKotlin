package com.example.retrofitexamplekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexamplekotlin.R
import com.example.retrofitexamplekotlin.databinding.RowItemBinding
import com.example.retrofitexamplekotlin.model.ResultUsers
import retrofit2.http.GET

class UsersAdapter(val data: List<ResultUsers>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
//        val user = data!!.get(position)
//        holder.nama?.text = user.name
//        holder.email?.text = user.email
//        holder.notelp?.text = user.phone
//
//        val address = user.address
//        holder.alamat?.text = address!!.street + ", " + address?.city + ", " + address?.suite + ", " + address.zipcode
    }

    class MyHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get:ResultUsers?){
            binding.nama.text = get?.name
            binding.email.text = get?.email
            binding.notelp.text = get?.phone
//
            val address = "${get?.address?.street}, ${get?.address?.suite}, ${get?.address?.city}, ${get?.address?.zipcode}"
//
            binding.alamat.text = address
        }
//           var nama:TextView? = null
//           var email:TextView? = null
//           var notelp:TextView? = null
//           var alamat:TextView? = null

//
//           init{
//               nama = itemView.findViewById(R.id.nama)
//               email= itemView.findViewById(R.id.email)
//               notelp = itemView.findViewById(R.id.notelp)
//               alamat = itemView.findViewById(R.id.alamat)
//           }

    }
}