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

        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener {
            drawingView.clearCanvas()
        }

        val btnRed: Button = findViewById(R.id.btnRed)
        btnRed.setOnClickListener {
            drawingView.setColor(Color.RED)
        }

        val btnBlue: Button = findViewById(R.id.btnBlue)
        btnBlue.setOnClickListener {
            drawingView.setColor(Color.BLUE)
        }
    }
}
