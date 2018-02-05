package com.example.nam.demobasekotlin.ui.menufind.subfragment.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Constant
import com.example.nam.demobasekotlin.common.Router
import com.example.nam.demobasekotlin.models.map.Example
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject


@Suppress("DEPRECATION")
/**
 * Created by ThanhNam on 1/7/2018.
 */
class MapFragment : BaseFragment(), OnMapReadyCallback, MapsView {
    @Inject
    lateinit var presenter: MapPresenter
    @Inject
    lateinit var mRouter:Router
    private lateinit var mMap: GoogleMap
    lateinit var mMapView: MapView
    lateinit var mLocationManager: LocationManager
    private val LOCATION_UPDATE_MIN_DISTANCE: Float = 10f
    private val LOCATION_UPDATE_MIN_TIME: Long = 5000
    private lateinit var currentLocation: Location
    private val MAP: Int = 1
    private val mLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (location != null) {
                // Logger.d(String.format("%f, %f", location.latitude, location.longitude))
                drawMarker(location)
                currentLocation=location
                var location = "${currentLocation.latitude},${currentLocation.longitude}"
                App.get().currentPosition=location
                mLocationManager.removeUpdates(this)
            } else {
                // Logger.d("Location is null")
            }
        }

        override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {

        }

        override fun onProviderEnabled(s: String) {

        }

        override fun onProviderDisabled(s: String) {

        }
    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_map
    }

    override fun initData() {

    }


    override fun initView() {
        mMapView = mRootView.findViewById(R.id.map)
        mMapView.onCreate(null)
        mMapView.onResume()
        mMapView.getMapAsync { map -> mMap = map }
        if (ContextCompat.checkSelfPermission(this.activity!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MAP)
        }
        mLocationManager = activity!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {
        val isGPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        var location: Location? = null
        if (!(isGPSEnabled || isNetworkEnabled))
        else {
            if (isNetworkEnabled) {
                mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        LOCATION_UPDATE_MIN_TIME, LOCATION_UPDATE_MIN_DISTANCE, mLocationListener)
                location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            }

            if (isGPSEnabled) {
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_UPDATE_MIN_TIME, LOCATION_UPDATE_MIN_DISTANCE, mLocationListener)

                location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            }
        }
        if (location != null) {
            //Logger.d(String.format("getCurrentLocation(%f, %f)", location.latitude, location.longitude))
            drawMarker(location)
            currentLocation = location
            var location = "${currentLocation.latitude},${currentLocation.longitude}"
            App.get().currentPosition=location
            presenter.callApi(location)
        }
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (ContextCompat.checkSelfPermission(this.activity!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MAP)
        }
    }


    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MAP) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true)
                getCurrentLocation()
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onResume() {
        super.onResume()
        mMapView.onResume()
        mMapView.getMapAsync {
            if (doesUserHavePermission()) {
                mMap.setMyLocationEnabled(true)
                getCurrentLocation()

            }


        }

    }

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
        mLocationManager.removeUpdates(mLocationListener)
    }

    private fun doesUserHavePermission(): Boolean {
        val result = context!!.checkCallingOrSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED
    }

    override fun onFail(toString: String) {
        Log.e("onFailure", toString)
    }

    override fun onSuccess(response: Example) {
        for (i in 0 until response.results!!.size) {
            Log.e("lat", response.results!!.get(i).geometry!!.location!!.lat.toString())
            Log.e("lng", response.results!!.get(i).geometry!!.location!!.lng.toString())
            addMarker(response.results!!.get(i).geometry!!.location!!, response.results!!.get(i).name)
        }

    }

    private fun drawMarker(location: Location) {
        if (mMap != null) {
            mMap.clear()
            val gps = LatLng(location.latitude, location.longitude)
            mMap.addMarker(MarkerOptions().position(gps).title("current possion"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gps, 13f))


        }
    }

    private fun addMarker(location: com.example.nam.demobasekotlin.models.map.Location, name: String?) {
        val gps = LatLng(location.lat!!, location.lng!!)
        mMap.addMarker(MarkerOptions().position(gps).title(name))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gps, 13f))
    }
}