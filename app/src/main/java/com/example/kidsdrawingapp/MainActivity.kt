package com.example.kidsdrawingapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var drawingView: DrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawingView)

        val clearButton: Button = findViewById(R.id.clearButton)
        clearButton.setOnClickListener {
            drawingView.clearCanvas()
        }

        val redButton: Button = findViewById(R.id.redButton)
        redButton.setOnClickListener {
            drawingView.setColor(Color.RED)
        }

        val blueButton: Button = findViewById(R.id.blueButton)
        blueButton.setOnClickListener {
            drawingView.setColor(Color.BLUE)
        }

        val blackButton: Button = findViewById(R.id.blackButton)
        blackButton.setOnClickListener {
            drawingView.setColor(Color.BLACK)
        }
    }
}
