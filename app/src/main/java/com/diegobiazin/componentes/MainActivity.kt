package com.diegobiazin.componentes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        if(id == R.id.buttonToastMe){
            Toast.makeText(this, "Toast notification!", Toast.LENGTH_LONG).show()
        }
    }

    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
    }
}
