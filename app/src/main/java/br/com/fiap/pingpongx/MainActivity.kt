package br.com.fiap.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        instancia os valores já digitados para não serem perdidos no lifecycle da aplicação
        mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        setupPlayers()

        registerObserver()

//        atribui os valores de pontuação ao clicar no ponto
        btPlayer1Score.setOnClickListener {
            mainViewModel.goalPlayer1()
        }

        btPlayer2Score.setOnClickListener {
            mainViewModel.goalPlayer2()
        }

        btRevenge.setOnClickListener {
            mainViewModel.revenge()
        }

        btFinish.setOnClickListener{
            finish()
        }
    }

    private fun registerObserver() {
        mainViewModel.playerOneScore.observe(this, Observer {
            tvPlayer1Score.text = it.toString()
        })
        mainViewModel.playerTwoScore.observe(this, Observer {
            tvPlayer2Score.text = it.toString()
        })
    }

    private fun setupPlayers() {
//     recebendo o valor passado pela tela anterior
       tvPlayer1Name.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
       tvPlayer2Name.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }
}
