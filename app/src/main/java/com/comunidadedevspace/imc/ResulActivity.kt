package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Criei uma variavel para armazenar a chave de acesso dos dados
const val KEY_RESULT_IMC = "ResulActivity.KEY_IMC"

class ResulActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resul)

        // Recebendo os dados passados da tela MainActivity (Pacote)
        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        // Recuperando os por ID
        val tvResult = findViewById<TextView>(R.id.tv_resultado)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        // Mudando o texto que esta vazio, para um texto que veio de resultado
                            // Convertendo result que é um numero para um texto
        tvResult.text = result.toString()

        val classificacao: String = if(result <= 18.5f){
            "Magreza"
        }else if(result > 18.5f && result <= 24.9f){
            "Normal"
        }else if(result >= 25.0f && result <= 29.9){
            "Sobrepeso"
        }else if(result >= 30.0 && result <= 39.9){
            "Obesidade nivel II"
        }else{
            "Obesidade Grave!! Faça um exercício e coma menos!"
        }

        tvClassificacao.text = classificacao



    }
}