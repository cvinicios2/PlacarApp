package br.com.fiap.placarapp

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_placar.*

class PlacarActivity : AppCompatActivity() {

    private var golCasa = 0
    private var golVisitante = 0

    private lateinit var placarViewModel: PlacarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        placarViewModel = ViewModelProviders.of(this).get(PlacarViewModel::class.java)

        tvTimeCasa.text = intent.getStringExtra("TIME_CASA")
        tvTimeVisitante.text = intent.getStringExtra("TIME_VISITANTE")

        tvPlacarCasa.text = "${placarViewModel.golCasa}"
        tvPlacarVisitante.text = "${placarViewModel.golVisitante}"

        btGolCasa.setOnClickListener{
            placarViewModel.golCasa ++
            tvPlacarCasa.text = "${placarViewModel.golCasa}"
        }

        btGolVisitante.setOnClickListener {
            placarViewModel.golVisitante ++
            tvPlacarVisitante.text = "${placarViewModel.golVisitante}"
        }
    }
}
