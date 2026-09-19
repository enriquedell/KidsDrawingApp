package com.example.kidsdrawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var drawPath = Path()
    private var drawPaint = Paint()
    private var canvasPaint = Paint(Paint.DITHER_FLAG)
    private lateinit var drawCanvas: Canvas
    private lateinit var canvasBitmap: Bitmap

    private var currentColor = Color.BLACK
    private var brushSize = 20f

    init {
        setupPaint()
    }

    private fun setupPaint() {
        drawPaint.color = currentColor
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = brushSize
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawPath.moveTo(x, y)
            MotionEvent.ACTION_MOVE -> drawPath.lineTo(x, y)
            MotionEvent.ACTION_UP -> {
                drawCanvas.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
        }
        invalidate()
        return true
    }

    fun setColor(newColor: Int) {
        currentColor = newColor
        drawPaint.color = currentColor
    }

    fun setBrushSize(newSize: Float) {
        brushSize = newSize
        drawPaint.strokeWidth = brushSize
    }

    fun clearCanvas() {
        drawCanvas.drawColor(Color.WHITE)
        invalidate()
    }
}
