package com.example.nam.demobasekotlin.Util

import android.content.Context
import android.widget.Toast

/**
 * Created by nam on 13/12/2017.
 */
class ToastUltil {
    companion object {
        fun show(context: Context, content: String) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
        }
    }
}