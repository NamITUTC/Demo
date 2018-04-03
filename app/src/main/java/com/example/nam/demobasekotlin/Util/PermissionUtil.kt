package com.example.nam.demobasekotlin.Util


import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.content.ContextCompat


/**
 * Created by ThanhNam on 1/30/2018.
 */
class PermissionUtil {
    companion object {
        fun requestPermission(permission: String, context: Context, requestCode: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(context as Activity, arrayOf(permission), requestCode)
                }
            }
        }
    }
}