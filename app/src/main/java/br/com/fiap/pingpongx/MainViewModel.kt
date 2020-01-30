package br.com.fiap.pingpongx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// classe criada para salvar as variáveis no lifecycle data, durante rotação de tela
class MainViewModel: ViewModel() {

    var playerOneScore = MutableLiveData<Int>()
    var playerTwoScore = MutableLiveData<Int>()

    init {
        revenge()
    }

    fun goalPlayer1() {
//        o .plus é necessário pq a variável é do tipo mutable e pra adição precisa
        playerOneScore.value = playerOneScore.value?.plus(1)
    }

    fun goalPlayer2() {
        playerTwoScore.value = playerTwoScore.value?.plus(1)
    }

    fun revenge() {
//        o .value é necessário pq a variável é do tipo mutable
        playerOneScore.value = 0
        playerTwoScore.value = 0
    }

}