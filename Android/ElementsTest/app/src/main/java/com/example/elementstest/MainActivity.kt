package com.example.elementstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val imgElement: ImageView = findViewById(R.id.imgElement)
    val chkFillWithColor: CheckBox = findViewById(R.id.chkFillWithColor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chkFillWithColor.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.chkFillWithColor -> toggleImageColor()
        }
    }

    private fun toggleImageColor() {
        imgElement.setColorFilter(if (chkFillWithColor.isChecked) R.color.white else R.color.purple_700)
    }
}