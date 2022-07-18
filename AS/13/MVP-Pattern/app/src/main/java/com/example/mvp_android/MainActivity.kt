package com.example.mvp_android


import android.widget.Button
import android.widget.TextView

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import com.example.mvp_android.contracts.Contract
import com.example.mvp_android.models.Model
import com.example.mvp_android.presenters.Presenter



class MainActivity : AppCompatActivity(), Contract.View {

    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())

        this.button!!.setOnClickListener(View.OnClickListener
        { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView!!.text = string
    }
}