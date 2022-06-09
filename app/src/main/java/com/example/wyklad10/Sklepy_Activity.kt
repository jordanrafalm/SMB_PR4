package com.example.wyklad10

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.wyklad10.databinding.ActivityMainBinding
import com.example.wyklad10.room.Sklep
import com.example.wyklad10.viewmodel.SklepyViewModel
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sklepy.*




class Sklepy_Activity : AppCompatActivity() {
    private lateinit var viewModel: SklepyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sklepy)


        val perms = arrayOf(
            android.Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val requestCode = 1
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(perms, requestCode)
        }

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as
                LocationManager
        val criteria = Criteria()
        criteria.isAltitudeRequired = true
        criteria.accuracy = Criteria.ACCURACY_FINE
        criteria.powerRequirement = Criteria.NO_REQUIREMENT
        val provider = locationManager.getBestProvider(criteria, false)
        val location = locationManager.getLastKnownLocation(provider.toString())

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(SklepyViewModel::class.java)

        dodajbt.setOnClickListener {
            var message =
                Toast.makeText(applicationContext, "sklep został dodany", Toast.LENGTH_SHORT)
            val nazwa: String = nazwaET.text.toString()
            val opis: String = opisET.text.toString()
            val promien: String = promienET.text.toString()
         val lokalizacja: Double = location!!.latitude.toDouble()
            val lokalizacja1: Double = location!!.longitude.toDouble()
            val sklep = Sklep(nazwa, opis, promien, lokalizacja, lokalizacja1 )

            nazwaET.text.clear()
            opisET.text.clear()
            promienET.text.clear()
            viewModel.insertSklep(sklep)

            if (location != null) {
                val toast = Toast.makeText(
                    applicationContext,
                    " Lokalizacja sklepu to: Szerokośc: ${location.latitude}, Długośc: ${location.longitude}, ",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 140)
                toast.show()


            }}
        pokazBT.setOnClickListener {
            val intent = Intent(applicationContext,
            ShowListActivity::class.java)
            startActivity(intent)
        }

        mapaBT.setOnClickListener {


            val myIntent = Intent(this, MapsActivity::class.java)
            myIntent.putExtra("latitude1", location!!.latitude)
            myIntent.putExtra("longitude1", location!!.longitude)
            startActivity(myIntent)


        }

           }








        }




