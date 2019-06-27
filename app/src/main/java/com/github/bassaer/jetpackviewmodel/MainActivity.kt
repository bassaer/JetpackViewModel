package com.github.bassaer.jetpackviewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var leftText: TextView
    private lateinit var rightText: TextView
    private lateinit var fab: FloatingActionButton
    private lateinit var viewModel: MainViewModel
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        leftText = findViewById(R.id.left_text)
        rightText = findViewById(R.id.right_text)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getData().observe(this, Observer { data ->
            leftText.text = data.toString()
        })

        fab = findViewById<FloatingActionButton>(R.id.fab).apply {
            setOnClickListener {
                viewModel.countUp()
                rightText.text = (++count).toString()
            }
        }
    }
}
