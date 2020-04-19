package com.example.courseinfo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET( "/api/v1/courses")
    fun fetchAllCourses(): Call<List<Course>>
}




