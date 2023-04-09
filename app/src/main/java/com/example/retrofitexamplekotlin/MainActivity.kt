package com.example.retrofitexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitexamplekotlin.adapter.UsersAdapter
import com.example.retrofitexamplekotlin.databinding.ActivityMainBinding
import com.example.retrofitexamplekotlin.model.ResultUsers
import com.example.retrofitexamplekotlin.services.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        NetworkConfig().getServices()
            .getUsers()
            .enqueue(object : Callback<List<ResultUsers>>{
                override fun onResponse(
                    call: Call<List<ResultUsers>>,
                    response: Response<List<ResultUsers>>
                ) {
                    binding.rvUser.adapter = UsersAdapter(response.body())
                }

                override fun onFailure(call: Call<List<ResultUsers>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                }

            })
    }
}