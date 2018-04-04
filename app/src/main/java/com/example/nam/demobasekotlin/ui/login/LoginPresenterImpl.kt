package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.common.Constant
import com.example.nam.demobasekotlin.ui.register.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import java.lang.Exception
import javax.inject.Inject


/**
 * Created by nam on 20/12/2017.
 */
class LoginPresenterImpl : BasePresenterImpl<LoginView>, LoginPresenter {
    override fun saveUser(user: User?) {

    }


    var fAuth: FirebaseAuth
    var dbReference: DatabaseReference


    @Inject constructor(fAuth: FirebaseAuth,
                        dbReference: DatabaseReference
    ) {
        this.fAuth = fAuth
        this.dbReference = dbReference

    }

    override fun onSignIn(email: String, pass: String) {
        fAuth.signInWithEmailAndPassword(email, pass)
                .addOnSuccessListener {
                    getView()!!.onLoginSuccessfull()
                }
                .addOnFailureListener { exception: Exception ->
                    getView()!!.onRequestFailure(exception.toString())
                }
    }

    override fun checkEmailVerified() {
        val user = fAuth.currentUser
        if (user != null) {
            if (user.isEmailVerified) {
                getUserDatabase(user.uid)

            } else {
                fAuth.signOut()
                getView()!!.onViriFail()

            }
        }

    }

    override fun getUserDatabase(uid: String) {
        val databaseUser: DatabaseReference =
                dbReference.child(Constant.USERS_PATH).child(uid)
        databaseUser.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                getView()!!.onVerified(user)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                getView()!!.onRequestFailure(databaseError.toString())
            }
        })

    }


    override fun dismissUser() {
        //  prefsEditor.clear().commit()
    }

    override fun rememberUser(email: String, pass: String) {
        /*  prefsEditor.putString(Constant.LOGIN_EMAIL, email)
                  .putString(Constant.LOGIN_PASS, pass)
                  .commit()*/
    }
}