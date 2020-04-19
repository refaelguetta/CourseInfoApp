package com.example.courseinfo

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.56.1:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)
        api.fetchAllCourses().enqueue(object : Callback<List<Course>>{
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                d("course", "OnResponse:")
                //: ${response.body()!![0].courseName}
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                d("course", t?.message)
            }


        })

    }
}
