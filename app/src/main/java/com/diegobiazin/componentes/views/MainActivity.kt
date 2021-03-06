package com.diegobiazin.componentes.views

import android.app.ProgressDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.*
import com.diegobiazin.componentes.R
import com.diegobiazin.componentes.mock.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        loadSpinner()
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
            val snack = Snackbar.make(constraintLayout, "Snack bar notification!", Snackbar.LENGTH_SHORT)

            snack.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).setTextColor(Color.YELLOW)

            //snack.view.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))
            snack.view.setBackgroundColor(Color.RED)

            //resources.getColor(R.color.colorAccent)
            ContextCompat.getColor(this, R.color.colorAccent)

            snack.setAction("Desfazer", {
                Snackbar.make(constraintLayout, "Ação desfeita", Snackbar.LENGTH_SHORT).show()
            })

            snack.setActionTextColor(Color.YELLOW)

            snack.show()
        } else if (id == R.id.buttonGetSpinner) {
            //val value = spinnerDynamic.selectedItem.toString()
            val value = spinnerDynamic.selectedItemPosition.toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()

        } else if (id == R.id.buttonSetSpinner) {
            spinnerDynamic.setSelection(3)
        } else if (id == R.id.buttonProgress) {
            val progress: ProgressDialog = ProgressDialog(this)
            progress.setTitle("Título")
            progress.setMessage("Mensagem")
            progress.show()

//            progress.hide()
//            progress.dismiss()
        } else if (id == R.id.buttonGetSeek) {

            val value = seekValue.progress.toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()

        } else if (id == R.id.buttonSetSeek) {
            seekValue.progress = 10
        }
    }

    private fun loadSpinner() {
        val list = Mock.getList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        spinnerDynamic.adapter = adapter
    }

    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
        buttonSnackMe.setOnClickListener(this)
        buttonGetSpinner.setOnClickListener(this)
        buttonSetSpinner.setOnClickListener(this)
        buttonProgress.setOnClickListener(this)
        buttonGetSeek.setOnClickListener(this)
        buttonSetSeek.setOnClickListener(this)

        spinnerDynamic.onItemSelectedListener = this

        seekValue.setOnSeekBarChangeListener(this)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val id = view.id
        if (id == R.id.spinnerDynamic) {
            val value: String = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }
    }

    override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
        val id = seek.id

        if (id == R.id.seekValue) {
            textSeekValue.text = progress.toString()
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar) {
    }

    override fun onStopTrackingTouch(p0: SeekBar) {
    }
}
