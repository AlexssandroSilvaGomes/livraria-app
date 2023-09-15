package br.senai.sp.jandira.ds3t_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class Cadastro_Categoria : AppCompatActivity() {
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)

        //criacao da instancia ativa do retrofit
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //recupera o objeto de edittext do formulario de cadastro de categoria
        val text = findViewById<EditText>(R.id.txtCategoria)

        //trata o evento de clique ou toque no botao
        findViewById<Button>(R.id.btnCadastrarCategoria).setOnClickListener(){
            //chama a funcao passando o valor inserido no edittext como parametro
            createCategory(text.text.toString())
        }
    }

    //funcao que insere nova categoria
    private fun createCategory(nome_categoria: String) {
        lifecycleScope.launch {
            //criacao do corpo de dados em formato json
            val body = JsonObject().apply {
                addProperty("nome_categoria", nome_categoria)
            }
            //criacao e envio de dados para a rota de cadastrar categoria
            val result = apiService.createCategory(body)
            //log de teste para validar o sucesso ou fracasso da chamada
            if(result.isSuccessful) {
                Log.e("createdata", "${result.body()?.get("mensagemStatus")}")
            } else {
                Log.e("createdata", "${result.message()}")
            }

        }
    }
}