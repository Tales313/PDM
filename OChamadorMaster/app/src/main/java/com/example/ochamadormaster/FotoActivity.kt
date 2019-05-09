package com.example.ochamadormaster

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class FotoActivity: AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var btAbrirCamera: Button
    private lateinit var btVoltar: Button
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)

        val msg = intent.getStringExtra("MSG_IDA")
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        this.btAbrirCamera = findViewById(R.id.btAbrirCamera)
        this.btVoltar = findViewById(R.id.btVoltar)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.btAbrirCamera.setOnClickListener({abrirCamera(it)})
        this.btVoltar.setOnClickListener({voltar(it)})
    }

    private fun abrirCamera(view: View) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivFoto.setImageBitmap(imageBitmap)
        }
    }

    fun voltar(view: View) {
        val it = Intent()
        it.putExtra("MSG_VOLTA", "Voltou pra Main Activity")
        setResult(Activity.RESULT_OK, it)
        finish()
    }
}