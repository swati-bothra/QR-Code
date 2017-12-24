package com.example.yolo.qrcode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_scan.setOnClickListener(View.OnClickListener {
            var intentIntegrator : IntentIntegrator = IntentIntegrator(this)
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            intentIntegrator.setPrompt("Scan")
            intentIntegrator.setCameraId(0)
            intentIntegrator.setBeepEnabled(true)
            intentIntegrator.setBarcodeImageEnabled(true)
            intentIntegrator.initiateScan()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var intentResult : IntentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if (intentResult != null){
             if (intentResult.contents == null){
                 Toast.makeText(this,"Scan Cancelled ",Toast.LENGTH_LONG).show()
             }
            else{
                 Toast.makeText(this,intentResult.contents,Toast.LENGTH_LONG).show()
             }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}
