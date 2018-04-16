package com.example.nam.demobasekotlin.ui.register

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.common.Constant
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class RegisterPresenterImpl : BasePresenterImpl<RegisterView>, RegisterPresenter {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference

    @Inject constructor(firebaseAuth: FirebaseAuth, databaseReference: DatabaseReference) {
        this.firebaseAuth = firebaseAuth
        this.databaseReference = databaseReference
    }

    override fun onSignUp(email: String, pass: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result.user
                        firebaseUser?.let { firebaseUser ->
                            sendVeriEmail(firebaseUser)

                        }
                    }
                }
                .addOnFailureListener { exception ->
                    getView()!!.onRequestFailure(exception.toString())
                }
    }

    private fun sendVeriEmail(firebaseUser: FirebaseUser) {

        val user = firebaseAuth.getCurrentUser()
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    getView()!!.onSignUpSuccessful()
                } else {
                    getView()!!.onRequestFailure("lỗi")
                }
            }
        }
    }


    override fun onCreatUserDatabase(email: String, pass: String) {
        val id = firebaseAuth.currentUser!!.uid
        val userName = (email.split("@".toRegex()))[0]
        val currentUser = User(id, userName, email, "", System.currentTimeMillis())
        databaseReference.child(Constant.USERS_PATH).child(id).setValue(currentUser)
                .addOnSuccessListener {
                    getView()!!.onCreateUserSuccessful()

        }.addOnFailureListener { e->
                    getView()!!.onCreateUserFail(e)
                }




    }

}