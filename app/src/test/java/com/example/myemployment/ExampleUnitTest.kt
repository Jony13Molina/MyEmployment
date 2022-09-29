package com.example.myemployment

import com.example.myemployment.Main.EmployeeService
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `can get employment json`() {
        // call the api

        val gson = GsonBuilder()
            .create()

        val retroBuild = Retrofit.Builder()
            .baseUrl("https://s3.amazonaws.com/sq-mobile-interview/employees.json")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val serviceReq = retroBuild.create(EmployeeService::class.java)

        val call = serviceReq.getEmployees()


        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                assert(response.code().equals(200))
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


}
