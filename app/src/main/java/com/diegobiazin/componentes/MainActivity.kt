package com.diegobiazin.componentes

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    override fun onClick(v: View) {
        val id = v.id

        if (id == R.id.buttonToastMe) {
            val toast = Toast.makeText(this, "Toast notification!", Toast.LENGTH_LONG)

            //Layout padrão toast
            //toast.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.GREEN)
            val toastLayout = layoutInflater.inflate(R.layout.toast_custom, null)
            toast.view = toastLayout

            val textView = toast.view.findViewById<TextView>(R.id.textMessage)
            textView.setTextColor(Color.RED)
            textView.setText("Toast notification!")

            toast.show()
        } else if (id == R.id.buttonSnackMe) {
            Snackbar.make(constraintLayout, "Snack bar notification!", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
        buttonSnackMe.setOnClickListener(this)
    }
}
