package com.example.myemployment.Main.EmployeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myemployment.Main.Models.Employee
import com.example.myemployment.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class EmployeeAdapter(var employeeList : MutableList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    lateinit var myListCLick : ListClick
    interface ListClick {
        fun onClick(view: View?, position: Int)
    }

    fun setMyListClick(listener: ListClick) {
        this.myListCLick = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParent = false

        val view = inflater.inflate(R.layout.employee_card_view, parent, shouldAttachToParent)

        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

        val employeeItem = employeeList[position]


        holder.setEmployeeInfo(employeeItem, myListCLick, position)

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }



    class EmployeeViewHolder(v: View) : RecyclerView.ViewHolder(v){
        private var view: View = v

        private lateinit var  employee : Employee
        private var employeeTeam: TextView = view.findViewById(R.id.employeeTeam)
        private var employeeType: TextView  = view.findViewById(R.id.employeeType)
        private var employeeName: TextView = view.findViewById(R.id.employeeName)
        private var employeeEmail: TextView = view.findViewById(R.id.employeeEmail)
        private var employeeNumber: TextView = view.findViewById(R.id.employeePhoneNumber)
        private var employeeBiography: TextView = view.findViewById(R.id.employeeBiography)
        private var employeePhoto: ImageView = view.findViewById(R.id.image_view)






        fun setEmployeeInfo(employee: Employee, myListCLick: ListClick, position: Int){
            this.employee = employee
            employeeTeam.text = employee.employeeTeam
            employeeType.text = employee.employeeType
            employeeName.text = employee.employeeName
            employeeEmail.text = employee.employeeEmail
            employeeNumber.text = employee.employeePhone
            employeeBiography.text = employee.employeeBio

            view.setOnClickListener(View.OnClickListener { v ->
                if (myListCLick != null) {
                    myListCLick.onClick(v, position)
                }
            })

            Picasso.get()
                .load(employee.employeePic)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .error(R.drawable.ic_baseline_error_24)
                .fit()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(employeePhoto)
        }


    }


}