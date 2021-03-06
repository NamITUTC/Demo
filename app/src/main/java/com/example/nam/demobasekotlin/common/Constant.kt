package com.example.nam.demobasekotlin.common

/**
 * Created by ThanhNam on 2/4/2018.
 */
open interface Constant {
    companion object {
        val LOCATION: String?="LOCATION"
        val HELLO: String?="HELLO"
        val USERS_PATH  = "USER"
        val LOADING="Vui lòng đợi..."
        val SPF_NAME = "saveUser"
        val VERY_FAIL = "email chưa được xác nhận, vui lòng kiểm tra hộp thư đến "
        val ERROR_ACOUNT_EXISTED = "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account."
        val ACOUNT_EXISTED = "địa chỉ email đã được sử dụng cho một tài khoản khác ! hê hê"
        val REGIS_ACTIVITY="regisActivity"
        val REQUEST_CHECK_EMAIL="kiểm tra hộp thư đến email để xác nhận tài khoản mới"
        val  LOGIN_PASS="loginpass"
        val  LOGIN_EMAIL="loginemail"
        val KEY_FROM_ACTIVTY="activity-from"
        val KEY_PASS="pass"
        val KEY_EMAIL="email"
        val SPLASH_ACTIVITY="splashActivity"
        val PRE_USER_AVATAR="userAvatar"
        val  PRE_USER_EMAIL="prefs_email"
        val  PRE_USER_NAME="prefs_name"
        val  PRE_USER_ID="prefs_id"
        val FRIEND_PATH ="FRIEND"
        val CHAT="CHAT"
        val LINKHEALTHYTIPS: String?="LINKHEALTHYTIPS"
        val LINKDETAILPATHOLOGICAL: String?="LINKDETAILPATHOLOGICAL"
        val LINKINFORPATHOLOGICAL: String?="LINKINFORPATHOLOGICAL"
    }
}