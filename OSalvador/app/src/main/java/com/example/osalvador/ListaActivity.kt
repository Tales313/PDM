package com.example.osalvador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListaActivity : AppCompatActivity() {
    private val UPDATE = 1

    private lateinit var lvPessoas: ListView
    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        this.lvPessoas = findViewById(R.id.lvPessoas)
        this.dao = PessoaDAO(this@ListaActivity)

        this.lvPessoas.adapter = ArrayAdapter<Pessoa>(
            this@ListaActivity, android.R.layout.simple_list_item_1, dao.get())
        this.lvPessoas.setOnItemClickListener(AtualizarPessoa())
    }

    inner class AtualizarPessoa : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val pessoa = dao.get(position+1)
            Log.i("PESSOA", "Id: ${pessoa!!.id} - Nome: ${pessoa.nome} - Idade: ${pessoa.idade}")
            var it = Intent(this@ListaActivity, UpdateActivity::class.java)
            it.putExtra("ID", pessoa.id.toString())
            it.putExtra("NOME", pessoa.nome)
            it.putExtra("IDADE", pessoa.idade.toString())
            startActivityForResult(it, UPDATE)
            // this@ListaActivity.intent.putExtra("ID", pessoa.id.toString())
            // this@ListaActivity.intent.putExtra("NOME", pessoa.nome)
            // this@ListaActivity.intent.putExtra("IDADE", pessoa.idade.toString())
            // setResult(Activity.RESULT_OK, this@ListaActivity.intent)
            // finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
            if(requestCode == this.UPDATE) {
                Toast.makeText(this@ListaActivity, "Pessoa Atualizada!", Toast.LENGTH_SHORT).show()
            }
    }
}
