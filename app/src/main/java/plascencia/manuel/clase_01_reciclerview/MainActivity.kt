package plascencia.manuel.clase_01_reciclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import plascencia.manuel.clase_01_reciclerview.adapter.Adapter
import plascencia.manuel.clase_01_reciclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var editTextmonto: EditText
    private lateinit var editTextdias: EditText
    private lateinit var editTextRate: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewresultado: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the views here after setting the content view
        editTextmonto = findViewById(R.id.editTextmonto)
        editTextdias = findViewById(R.id.editTextdias)
        editTextRate = findViewById(R.id.editTextRate)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewresultado = findViewById(R.id.textViewresultado)

        initRecyclerView()

        buttonCalculate.setOnClickListener {
            val monto = editTextmonto.text.toString().toDouble()
            val dias = editTextdias.text.toString().toInt()
            val rate = editTextRate.text.toString().toDouble() / 100.0
            val resultado = calculateCetes(monto, dias, rate)
            textViewresultado.text = "El monto final es: $resultado"
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerSuperHero.layoutManager = LinearLayoutManager(this)
        binding.recyclerSuperHero.adapter = Adapter { superHero ->
            onItemSelected(superHero)
        }
        binding.recyclerSuperHero.addItemDecoration(decoration)
    }

    private fun onItemSelected(superHero: Cetes) {
        Toast.makeText(this, superHero.superhero, Toast.LENGTH_SHORT).show()
    }

    private fun calculateCetes(monto: Double, dias: Int, rate: Double): Double {
        // Cálculo de Cetes
        // Fórmula de interés simple: Monto final = Monto inicial * (1 + tasa * (días / 360))
        return monto * (1 + rate * (dias.toDouble() / 360))
    }
}
