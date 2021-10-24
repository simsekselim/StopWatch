package com.simsekselim.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

var number = 0
    var runnable = Runnable {  }
    var handler = Handler()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view : View){
        //Runnable
        runnable = object : Runnable {
            override fun run() {

                number = number +1

                textView.text = "Time : $number"





                handler.postDelayed(this,1000)
            }


        }
            handler.post(runnable)

    }
    fun stop(view : View){
        //Runnable
        handler.removeCallbacks(runnable)

        textView.text = "Time : $number"


    }
    fun restart(view : View){
        //AlertDialog
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Restart")
        alert.setMessage("Are You Sure?")
        alert.setNegativeButton("No"){dialog,which ->
            Toast.makeText(applicationContext,"EXIT",Toast.LENGTH_LONG).show()

        }
        alert.setPositiveButton("Yes"){dialog,which ->
            Toast.makeText(applicationContext,"RESTART",Toast.LENGTH_LONG).show()
            number = 0
            textView.text = "Time : 0"


        }

        alert.show()

    }
}