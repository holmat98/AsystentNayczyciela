package com.example.asystentnayczyciela.ViewModel

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnayczyciela.Model.DataSource
import com.example.asystentnayczyciela.Model.Repositories.TestRepository
import com.example.asystentnayczyciela.Model.Teacher
import com.example.asystentnayczyciela.Model.Test
import com.example.asystentnayczyciela.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AdapterTest(var testList: LiveData<MutableList<Test>>): RecyclerView.Adapter<AdapterTest.TestHolder>() {
    inner class TestHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_test,parent,false)
        return TestHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        var opis = holder.itemView.findViewById<TextView>(R.id.opisTestu)
        var data = holder.itemView.findViewById<TextView>(R.id.dataTestu)

        data.text = testList.value?.get(position)?.testDate
        opis.text = testList.value?.get(position)?.topic

        val format = DateTimeFormatter.ofPattern("yyy/MM/dd")
        var testDate = LocalDate.parse(testList.value?.get(position)?.testDate, format)

        if(testDate >= LocalDate.now())
        {
            data.setBackgroundColor(Color.GREEN)
            opis.setBackgroundColor(Color.GREEN)
        }
        else
        {
            data.setBackgroundColor(Color.RED)
            opis.setBackgroundColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return testList.value?.size?:0
    }
}