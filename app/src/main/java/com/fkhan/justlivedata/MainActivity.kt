package com.fkhan.justlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fkhan.justlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var cityName: MutableLiveData<String> = MutableLiveData("bengaluru");

    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        cityName.observe(this, Observer {
            binding.cityName.text = it;
        })

        binding.button.setOnClickListener {
            if (count == 0) {
                cityName.value = "kolkata"
                count = 1
            } else {
                cityName.value = "hyderabad"
                count = 0
            }

            //no need to set value for textview explicitly
            //binding.cityName.text = cityName.value
        }
    }
}