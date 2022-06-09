package com.example.wyklad10

import android.content.Context
import android.location.Criteria
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wyklad10.databinding.ActivityMapsBinding
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_maps.*
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

     private lateinit var mMap: GoogleMap
     private lateinit var binding: ActivityMapsBinding

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMapsBinding.inflate(layoutInflater)
         setContentView(binding.root)
         val mapFragment = supportFragmentManager
             .findFragmentById(R.id.map) as SupportMapFragment
         mapFragment.getMapAsync(this)


     }


        override fun onMapReady(googleMap: GoogleMap) {


            val locationManager = getSystemService(Context.LOCATION_SERVICE) as
                    LocationManager
            val criteria = Criteria()
            criteria.isAltitudeRequired = true
            criteria.accuracy = Criteria.ACCURACY_FINE
            criteria.powerRequirement = Criteria.NO_REQUIREMENT
            val provider = locationManager.getBestProvider(criteria, false)
            val location = locationManager.getLastKnownLocation(provider.toString())


             mMap = googleMap

            //odebranie danycch z lokalizacją z aktywnosci sklepy
          val x =  getIntent().getDoubleExtra("latitude1",1.1)
            val y = getIntent().getDoubleExtra("longitude1",1.1)

             val marker1 = LatLng(x, y)
             val markerOptions = MarkerOptions()
             markerOptions.position(marker1)
             markerOptions.title("Sklep poprzednio dodany")

             mMap.addMarker(markerOptions)
             mMap.moveCamera(CameraUpdateFactory.newLatLng(marker1))
             mMap.isMyLocationEnabled = true


         }

         }

