package edu.iest.botones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class SegundaActivity : AppCompatActivity(), View.OnClickListener {

    private var cambioIcono : Boolean = false
    private lateinit var ivLogoIEST: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        var fraseRecibida = intent.getStringExtra("frase")
        var edadRecibida = intent.getIntExtra("edad", 0)

        Log.d("DATOS", "Datos recibidos con exito fueron frase $fraseRecibida y $edadRecibida ")

        var ivLogoIEST = findViewById<ImageView>(R.id.ivLogoIEST)
        ivLogoIEST.setOnClickListener{
            var arregloImagenes = arrayOf<Int>(R.drawable.logo_anahuac, R.drawable.icono_iest)
            if (cambioIcono){
                ivLogoIEST.setImageResource(arregloImagenes[0])
            }else{
                ivLogoIEST.setImageResource(arregloImagenes[1])
            }
            cambioIcono = !cambioIcono
            // ivLogoIEST.setImageResource(R.drawable.logo_anahuac)
        }

        var bnAbrirPantalla = findViewById<Button>(R.id.bnPantalla)
        bnAbrirPantalla.setOnClickListener{
            val i = Intent(this,MainActivity::class.java )
            startActivity(i)
            finish()
        }

        var bnCerrar = findViewById<Button>(R.id.bnCerrar)
        /*bnCerrar.setOnClickListener{
            finish()
        }*/
        bnCerrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.bnCerrar -> finish()
            R.id.bnPantalla -> {
                val i = Intent(this,MainActivity::class.java )
                startActivity(i)
                finish()
            }
            R.id.ivLogoIEST ->{
                var arregloImagenes = arrayOf<Int>(R.drawable.logo_anahuac, R.drawable.icono_iest)
                if (cambioIcono){
                    ivLogoIEST.setImageResource(arregloImagenes[0])
                }else{
                    ivLogoIEST.setImageResource(arregloImagenes[1])
                }
                cambioIcono = !cambioIcono
                // ivLogoIEST.setImageResource(R.drawable.logo_anahuac)
            }
        }
    }

}