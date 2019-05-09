package com.example.osalvador

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var dao: PessoaDAO

    private lateinit var etMainNome: EditText
    private lateinit var etMainIdade: EditText
    private lateinit var btSalvar: Button

    private lateinit var etId: EditText
    private lateinit var btDelete: Button

    private lateinit var btListaView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = PessoaDAO(this@MainActivity)

        etMainNome = findViewById(R.id.etMainNome)
        etMainIdade = findViewById(R.id.etMainIdade)
        btSalvar = findViewById(R.id.btSalvar)

        etId = findViewById(R.id.etId)
        btDelete = findViewById(R.id.btDelete)

        btListaView = findViewById(R.id.btListaView)

        btSalvar.setOnClickListener({add(it)})
        btDelete.setOnClickListener({delete(it)})
        btListaView.setOnClickListener({chamarViewListagem(it)})
    }

    private fun add(view: View?) {
        val nome = this.etMainNome.text.toString()
        val idade = this.etMainIdade.text.toString().toInt()
        val p = Pessoa(nome, idade)
        dao.insert(p)

        Toast.makeText(this, "Pessoa inserida!", Toast.LENGTH_SHORT).show()
    }

    private fun delete(view: View?) {
        val id = this.etId.text.toString().toInt()
        val pessoa = this.dao.get(id)

        if(pessoa != null) {
            dao.delete(id)
            Toast.makeText(this@MainActivity, "Pessoa deletada!", Toast.LENGTH_SHORT).show()
        }else
            Toast.makeText(this@MainActivity, "Esse id não existe :(", Toast.LENGTH_SHORT).show()

    }

    private fun chamarViewListagem(view: View?) {
        val it = Intent(this@MainActivity, ListaActivity::class.java)
        startActivity(it)
    }

}
