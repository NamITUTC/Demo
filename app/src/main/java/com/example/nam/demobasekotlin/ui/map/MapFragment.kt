package com.example.nam.demobasekotlin.ui.map

import android.annotation.SuppressLint
import butterknife.BindView
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.R.id.map
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

@Suppress("DEPRECATION")
/**
 * Created by ThanhNam on 1/7/2018.
 */
class MapFragment : BaseFragment(), OnMapReadyCallback {


    @Inject
    lateinit var presenter: MapPresenter
    private lateinit var mMap: GoogleMap

    @BindView(R.id.map)
    lateinit var mapFragment:SupportMapFragment

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_map
    }

    override fun initData() {

    }

    override fun initView() {

        mapFragment.getMapAsync(this)

    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMyLocationEnabled(true)

        mMap.setOnMyLocationChangeListener { location ->
            val sydney = LatLng(location!!.altitude, location.longitude)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}