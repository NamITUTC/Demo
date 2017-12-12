package com.example.nam.demobasekotlin.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View

@SuppressLint("Registered")
/**
* Created by nam on 12/12/2017.
*/
class Canvasss : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val papel = PapelView(this)
        setContentView(papel)


    }

    private class PapelView(context: Context?) : View(context) {

        @SuppressLint("DrawAllocation")
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val paint= Paint()
            paint.color = Color.WHITE


            canvas.drawPaint(paint)
            val ancho = canvas.width.toFloat()
            val alto = canvas.height.toFloat()

            //todo draw text

            paint.color=Color.BLACK
            paint.textSize=20f
            paint.isAntiAlias=true

            canvas.drawText("ancho"+ancho+"alto"+alto,30f,10f,paint)

            //todo drawline
            paint.color=Color.BLACK
            var i=0f
            while(i<=alto){

                Log.d("i",i.toString())
                canvas.drawLine(0f,i.toFloat(),ancho,i.toFloat(),paint)
                i+=100
            }
           /* canvas.drawLine(0f,40f,ancho,40f,paint)
            canvas.drawLine(0f,50f,ancho,50f,paint)
            canvas.drawLine(0f,60f,ancho,60f,paint)
            canvas.drawLine(0f,70f,ancho,70f,paint)
            canvas.drawLine(20f,0f,20f,alto,paint)*/

        }
    }
}