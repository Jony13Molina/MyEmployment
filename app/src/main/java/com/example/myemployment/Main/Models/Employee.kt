package com.example.myemployment.Main.Models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Employee(@SerializedName("team") val employeeTeam: String,@SerializedName(
    "full_name") val employeeName: String,@SerializedName("employee_type") val employeeType: String,
               @SerializedName("email_address")val employeeEmail: String,
               @SerializedName("phone_number")val employeePhone: String,
               @SerializedName("biography") val  employeeBio: String,
               @SerializedName("photo_url_small")val employeePic: String):Parcelable