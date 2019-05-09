package com.example.osalvador

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UpdateActivity : AppCompatActivity() {

    private lateinit var dao: PessoaDAO
    private lateinit var tvId: TextView
    private lateinit var etUpdateNome: EditText
    private lateinit var etUpdateIdade: EditText
    private lateinit var btAtualizar: Button

    private lateinit var id: String
    private lateinit var nome: String
    private lateinit var idade: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        dao = PessoaDAO(this@UpdateActivity)

        this.tvId = findViewById(R.id.tvId)
        this.id = intent.getStringExtra("ID")
        //this.tvId.setText(this.id)
        this.tvId.text = this.id

        this.etUpdateNome = findViewById(R.id.etUpdateNome)
        this.nome = intent.getStringExtra("NOME")
        //this.etUpdateNome.setText(this.nome)
        this.etUpdateNome.setText(this.nome)

        this.etUpdateIdade = findViewById(R.id.etUpdateIdade)
        this.idade = intent.getStringExtra("IDADE")
        //this.etUpdateIdade.setText(this.idade)
        this.etUpdateIdade.setText(this.idade)

        this.btAtualizar = findViewById(R.id.btAtualizar)

        this.btAtualizar.setOnClickListener({atualizar(it)})
    }

    private fun atualizar(view: View?) {
        val id = tvId.text.toString().toInt()
        val nome = etUpdateNome.text.toString()
        val idade = etUpdateIdade.text.toString().toInt()
        val p = Pessoa(id, nome, idade)
        dao.update(p)
        setResult(Activity.RESULT_OK, this@UpdateActivity.intent)
        finish()
    }

}
