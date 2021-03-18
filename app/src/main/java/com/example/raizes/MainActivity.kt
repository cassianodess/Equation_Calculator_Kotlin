package com.example.raizes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Gardando os ID's nas variáveis
        val btnCalc: Button = findViewById(R.id.btnCalcular)
        val lblx1: TextView = findViewById(R.id.lblX1)
        val lblx2: TextView = findViewById(R.id.lblX2)
        val resp: TextView = findViewById(R.id.lblResp)

        //Evento ao clicar no botão calcular.
        btnCalc.setOnClickListener {
            //Limpando a tela ao pressionar o botão
            lblx1.text = ""
            lblx2.text = ""
            resp.text = ""
            Bhaskara()
        }
    }//final


    private fun Bhaskara() {

        //Guardando ID's no escopo da função
        val atxt: EditText = findViewById(R.id.txtA)
        val btxt: EditText = findViewById(R.id.txtB)
        val ctxt: EditText = findViewById(R.id.txtC)
        val lblx1: TextView = findViewById(R.id.lblX1)
        val lblx2: TextView = findViewById(R.id.lblX2)
        val lblresp: TextView = findViewById(R.id.lblResp)

        //Convertendo input para número;
        val a = atxt.text.toString().toDoubleOrNull()
        val b = btxt.text.toString().toDoubleOrNull()
        val c = ctxt.text.toString().toDoubleOrNull()

        if (a == null || b == null || c == null) {
            lblresp.text = "[ERRO!] Campo(s) vazio(s)!"
            return
        } else if (a == 0.0 && b == 0.0 && c == 0.0) {
            lblresp.text = ""
            return
            //Se for reta, mostra a raiz
        } else if (a == 0.0 && b != 0.0 && c != 0.0) {
            val x: Double = -c / b
            lblx1.text = "É uma reta!"
            lblx2.text = "x = ${String.format("%.2f", x)}"
            return
        } else if (a == 0.0 && b == 0.0 && c != 0.0) {
            lblx1.text = "É uma constante!"
            lblx2.text = "y = ${c}"
            return
        } else if (a == 0.0 && b != 0.0 && c == 0.0) {
            lblx2.text = "É um ponto!"
            lblx1.text = "(x = 0, y = 0)"
            return
        }

        if (Delta(a, b, c) < 0) {
            lblresp.text = "Não há raízes reais!"
        } else {
            var x1: Double = (-b - sqrt(Delta(a, b, c))) / (2 * a)
            //Se o retor for zero, ele retorna -0, que não exite.
            if (x1 == -0.0) {
                x1 = 0.0
            }
            var x2: Double = (-b + sqrt(Delta(a, b, c))) / (2 * a)
            if (x2 == -0.0) {
                x2 = 0.0
            }

            lblx1.text = "x1 = ${String.format("%.2f", x1)}"
            lblx2.text = "x2 = ${String.format("%.2f", x2)}"

        }
    }

    private fun Delta(a: Double = 0.0, b: Double = 0.0, c: Double = 0.0): Double {
        return (b.pow(2.0) - (4 * a * c))

    }


}




