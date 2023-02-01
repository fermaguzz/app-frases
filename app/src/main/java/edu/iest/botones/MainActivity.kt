package edu.iest.botones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var  tvFrase : TextView
    private lateinit var  etFrase : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvFrase = findViewById(R.id.textViewFrase)
        etFrase = findViewById(R.id.editTextFrase)
        var bnMostrar = findViewById<Button>(R.id.buttonMostrar)

        bnMostrar.setOnClickListener{
            val frase = obtenerFrase()
            Snackbar.make(tvFrase, "Su frase fue $frase", Snackbar.LENGTH_LONG).show()
        }

        var bnSiguente = findViewById<Button>(R.id.bnSiguiente)
        bnSiguente.setOnClickListener{
            val i = Intent(this,SegundaActivity::class.java )
            i.putExtra("frase", obtenerFrase()) //Mandamos dato frase con valor que tenga la vista
            i.putExtra("edad", 21) //Mandamos dato "edad" con valor 21
            startActivity(i)
            finish()
        }
    }
    private fun obtenerFrase() : String{
        return etFrase.text.toString()
    }
}