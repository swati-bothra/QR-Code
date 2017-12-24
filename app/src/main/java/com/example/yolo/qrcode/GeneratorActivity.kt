package com.example.yolo.qrcode

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatReader
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_generator.*

class GeneratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)

        button_gen.setOnClickListener(View.OnClickListener {
            val textToQR : String = text.text.toString().trim()
            val multiFormatWriter :  MultiFormatWriter =  MultiFormatWriter()
            val bitMatrix : BitMatrix = multiFormatWriter.encode(textToQR,BarcodeFormat.QR_CODE,200,200)
            val barcodeEncoder : BarcodeEncoder = BarcodeEncoder()
            val bitmap : Bitmap = barcodeEncoder.createBitmap(bitMatrix)
            img_view.setImageBitmap(bitmap)
        })
    }
}
