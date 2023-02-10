package com.ayushwalker.spinner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ayushwalker.spinner.R.id.spMonths

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spMonths = findViewById<Spinner>(spMonths)

        // For spinner we need to create an anonymous class on onItemSelectedListener
        spMonths.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()
                // have to use this@MainActivity as we are inside Anonymous class and we need to pass the context of MainActivity..!
            }
            // AS we know, no item can selected, or leaved blanked, so, we can leave this function blanked.
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val spRanks = findViewById<Spinner>(R.id.spRanks)
        val customList = listOf("First", "Second", "Third", "Forth")
        spRanks.adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,customList)

        spRanks.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You clicked in ${adapterView?.getItemAtPosition(pos).toString()}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


    }


}

/*
NOTES:
1. Spinner uses a drop-down menu to store and choose data by using some string array..!
2. Also learn, how to run it at runtime..
 */