package com.example.ochamadormaster

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val FOTO = 1

    private lateinit var btHtml: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btEmail: Button
    private lateinit var btSMS: Button
    private lateinit var btCompartilharTexto: Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btYoutube: Button
    private lateinit var btFoto: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btSMS = findViewById(R.id.btSMS)
        this.btCompartilharTexto = findViewById(R.id.btCompartilharTexto)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btYoutube = findViewById(R.id.btYoutube)
        this.btFoto = findViewById(R.id.btFoto)


        this.btHtml.setOnClickListener({ html(it) })
        this.btDiscar.setOnClickListener({ discar(it) })
        this.btLigar.setOnClickListener({ ligar(it) })
        this.btEmail.setOnClickListener({ email(it) })
        this.btSMS.setOnClickListener({ sms(it) })
        this.btCompartilharTexto.setOnClickListener({ compartilharTexto(it) })
        this.btPonto.setOnClickListener({ ponto(it) })
        this.btRota.setOnClickListener({ rota(it) })
        this.btYoutube.setOnClickListener({ youtube(it) })
        this.btFoto.setOnClickListener({ foto(it) })
    }

    fun html(view: View){
        val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun discar(view: View){
        val uri = Uri.parse("tel:9090989026036")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    fun ligar(view: View){
//        val uri = Uri.parse("tel:9090989026036")
//        val it = Intent(Intent.ACTION_CALL, uri)
//        val call = Manifest.permission.CALL_PHONE
//        val granted = PackageManager.PERMISSION_GRANTED
//
//        if(ContextCompat.checkSelfPermission(this, call) == granted)
//            startActivity(it)
    }

    fun email(view: View){
        val uri = Uri.parse("mailto:marlon.fernando.16@outlook.com")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_SUBJECT, "treta")
        it.putExtra(Intent.EXTRA_TEXT, "android > ios")
        startActivity(it)
    }

    fun sms(view: View){
        val uri = Uri.parse("sms:989026036")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra("sms_body", "Knalia")
        startActivity(it)
    }

    fun compartilharTexto(view: View){
        val it = Intent(Intent.ACTION_SEND)
        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT, "01010101110100010101010101010010001011")
        //it.setPackage("com.whatsapp")
        startActivity(Intent.createChooser(it, "Compartilhar"))
    }

    fun ponto(view: View){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun rota(view: View){
        val origem = "-7.1356496,-34.8760932"
        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun youtube(view: View){
        var uri = Uri.parse("http://www.youtube.com/feed/subscriptions")
        var it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun foto(view: View){
        var it = Intent(this, FotoActivity::class.java)
        it.putExtra("MSG_IDA", "Foi pra Foto Activity")
        startActivityForResult(it, FOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
            if(requestCode == FOTO) {
                val msg = data?.getStringExtra("MSG_VOLTA")
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
    }
}
