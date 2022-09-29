package com.example.myemployment.Main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myemployment.Main.EmployeeAdapter.EmployeeAdapter
import com.example.myemployment.Main.Models.Employee
import com.example.myemployment.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), EmployeeAdapter.ListClick{

    private val TAG = "MainActivity"
    private lateinit var employeeList: MutableList<Employee>
    private lateinit var binding: ActivityMainBinding
    private lateinit var myEmployee: Employee
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        employeeList = mutableListOf()
        sendRequest()


    }


    private fun sendRequest() {

        var url = getRequestURL()

        val gson = GsonBuilder()
            .create()

        val retroBuild = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val serviceReq = retroBuild.create(EmployeeService::class.java)

        val call = serviceReq.getEmployees()


        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val body: JsonObject? = response.body()
                val listArrayJson = body?.getAsJsonArray("employees")



                if (response.code() == 200) {

                    CoroutineScope(Dispatchers.IO).launch{



                        withContext(Dispatchers.Main){

                    if (listArrayJson != null) {

                        for (i in 0 until listArrayJson.size()) {


                            try {
                                var employeeTeam =
                                    listArrayJson.get(i).asJsonObject.get("team").asString
                                var employeeName =
                                    listArrayJson.get(i).asJsonObject.get("full_name").asString
                                var employeeType =
                                    listArrayJson.get(i).asJsonObject.get("employee_type").asString
                                var employeeEmail =
                                    listArrayJson.get(i).asJsonObject.get("email_address").asString
                                var employeeNumber =
                                    listArrayJson.get(i).asJsonObject.get("phone_number").asString
                                var employeeBiography =
                                    listArrayJson.get(i).asJsonObject.get("biography").asString
                                var employeePhotoUrl =
                                    listArrayJson.get(i).asJsonObject.get("photo_url_small").asString





                                myEmployee = Employee(
                                    employeeTeam,
                                    employeeName,
                                    employeeType,
                                    employeeEmail,
                                    employeeNumber,
                                    employeeBiography,
                                    employeePhotoUrl
                                )
                                employeeList.add(myEmployee)

                            } catch (e: NullPointerException) {

                                Toast.makeText(
                                    this@MainActivity,
                                    "invalidating employee list due to malformed Json",
                                    Toast.LENGTH_LONG
                                ).show()

                                Log.e(TAG, e.toString())
                                return@withContext


                            }
                        }

                        linearLayoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = EmployeeAdapter(employeeList)
                        binding.recyclerList.layoutManager = linearLayoutManager
                        binding.recyclerList.adapter = adapter
                        adapter.setMyListClick(this@MainActivity)


                        //adapter.notifyDataSetChanged()

                        if (employeeList.isEmpty()) {
                            binding.emptyPosts.setVisibility(View.VISIBLE)
                        } else {
                            binding.emptyPosts.setVisibility(View.INVISIBLE)
                        }

                    }

                }
                    }

                } else {
                    try {
                        val jObjError = JSONObject(response.errorBody()!!.string())
                        Toast.makeText(
                            this@MainActivity,
                            jObjError.getJSONObject("error").getString("message"),
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                    }

                }

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e(TAG, t.toString())
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
    //method to get URL

    private fun getRequestURL(): String {


        val url = "https://s3.amazonaws.com/sq-mobile-interview/"

        return url


    }

    //if we click on the list then ask to reload list
    override fun onClick(view: View?, position: Int) {
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        alertDialogBuilder.setTitle("Do you want to reload list of employees")
        alertDialogBuilder.setPositiveButton(
            "Yes"
        ) { dialog, which ->
            employeeList.clear()
            sendRequest()
        }
        alertDialogBuilder.setNegativeButton(
            "Cancel"
        ) { arg0, arg1 -> }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }


}