package com.example.myemployment.Main
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*


interface EmployeeService {
    @GET("employees.json")
    fun getEmployees(): Call<JsonObject>
}