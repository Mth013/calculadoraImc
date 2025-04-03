package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Conecxao do iml com o MainActivity

        // Recuperar os componentes EditText
        // Criar uma variavel e associar(=) o componente de UI<TextInputEditText>
        // Recuperar o botao da tela
        // Colocar a acao no botao SetOnClickListener
        // Recuperar o texto digitado no edt peso

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // setOnClickListener para adicionar a ação de click no botao
        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if(pesoStr == "" || alturaStr == ""){
                // Mostrar mensagem para o usuario
                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            }else{
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                // Navegar para proxima tela
                // Criar o layout da proxima tela
                // Passar dados(resultado) para proxima tela

                // Chamando a próxima tela e levando dados até ela com INTENT
                val intent = Intent(this, ResulActivity::class.java)
                              // Variavel que armazena a chave de acesso dos dados para proxima tela
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

                println("Ação do botao " + resultado)
            }
        }


    }
}