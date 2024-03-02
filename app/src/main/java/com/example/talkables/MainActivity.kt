package com.example.talkables

import android.os.Bundle
import android.view.View
import android.view.View.*

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val palavras = arrayOf(
        "Compartilhe um momento de gratidão que viveu recentemente",
        "Descreva uma meta que alcançou e de que se orgulha muito",
        "Fale sobre uma viagem que mudou sua perspectiva",
        "Conte sobre uma experiência emocionante que teve este ano",
        "Compartilhe algo que aprendeu recentemente e achou fascinante",
        "Descreva um livro que leu e que o impactou profundamente",
        "Fale sobre uma tradição familiar que é especial para você",
        "Compartilhe uma memória feliz da sua infância",
        "Descreva um momento de superação que teve na vida",
        "Fale sobre uma paixão que ocupa grande parte do seu tempo",
        "Compartilhe uma história engraçada que aconteceu com você",
        "Descreva um hobby que gostaria de explorar no futuro",
        "Fale sobre uma pessoa que te inspira todos os dias",
        "Compartilhe um segredo que poucas pessoas conhecem sobre você",
        "Descreva um momento de conexão profunda com alguém",
        "Fale sobre uma experiência que o fez repensar seus valores",
        "Compartilhe um momento de grande alegria que viveu",
        "Descreva um sonho que realizou recentemente",
        "Fale sobre uma habilidade que gostaria de desenvolver mais",
        "Compartilhe um momento de grande admiração por alguém",
        "Descreva uma cena da natureza que o deixou maravilhado",
        "Fale sobre uma decisão importante que tomou recentemente",
        "Compartilhe uma música que tem um significado especial para você",
        "Descreva um lugar que gostaria muito de visitar um dia",
        "Fale sobre uma tradição que gostaria de começar na sua família",
        "Compartilhe um momento de autoconhecimento que teve",
        "Descreva uma qualidade que admira em si mesmo",
        "Fale sobre um momento de grande alívio que viveu",
        "Compartilhe uma meta pessoal que está trabalhando para alcançar",
        "Descreva uma experiência de aprendizado que teve recentemente",
        "Fale sobre um filme que o emocionou profundamente",
        "Compartilhe uma receita especial da sua família",
        "Descreva um lugar que o faz sentir em paz consigo mesmo",
        "Fale sobre uma amizade que valoriza muito",
        "Compartilhe um momento de grande felicidade na sua vida",
        "Descreva uma conquista que foi resultado de muito esforço",
        "Fale sobre uma experiência que te fez sentir-se mais forte",
        "Compartilhe um momento de grande inspiração que teve",
        "Descreva uma tradição cultural que aprecia muito",
        "Fale sobre uma decisão que mudou o rumo da sua vida",
        "Compartilhe uma história de sucesso que teve no trabalho",
        "Descreva uma cena do cotidiano que o faz feliz",
        "Fale sobre uma lição importante que aprendeu na vida",
        "Compartilhe um momento de grande empatia que viveu",
        "Descreva uma pessoa que te apoia incondicionalmente",
        "Fale sobre uma experiência que te fez crescer como pessoa",
        "Compartilhe um momento de grande orgulho pessoal",
        "Descreva uma tradição de fim de ano que aprecia",
        "Fale sobre um gesto de bondade que presenciou recentemente",
        "Compartilhe uma experiência que o fez perceber o quanto é amado"
    )

    private var indicesVisitados = mutableListOf<Int>()
    private var indiceAtual = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val button = findViewById<Button>(R.id.button)
        val buttonAnterior = findViewById<Button>(R.id.button_anterior)
        val buttonProximo = findViewById<Button>(R.id.button_proximo)
        val textoCentral = findViewById<TextView>(R.id.texto_central)

        buttonAnterior.visibility = View.GONE
        buttonProximo.visibility = View.GONE

        button.setOnClickListener {
            if (button.isEnabled) {
                val indiceAleatorio = Random.nextInt(palavras.size)
                textoCentral.text = palavras[indiceAleatorio]
                button.visibility = View.GONE
                indiceAtual = indiceAleatorio
                buttonProximo.visibility = View.VISIBLE
                buttonAnterior.visibility = View.VISIBLE
            }
        }

        buttonProximo.setOnClickListener {
            if (indicesVisitados.isNotEmpty()) {
                addIndexToVisitedList(indiceAtual)
            }
            val indiceAleatorio = getRandomIndex()
            textoCentral.text = palavras[indiceAleatorio]
            indiceAtual = indiceAleatorio
        }

        buttonAnterior.setOnClickListener {
            if (indicesVisitados.isNotEmpty()) {
                val ultimoIndice = indicesVisitados.removeAt(indicesVisitados.size - 1)
                textoCentral.text = palavras[ultimoIndice]
                indiceAtual = ultimoIndice
            }
        }
    }

    private fun getRandomIndex(): Int {
        var index: Int
        do {
            index = Random.nextInt(palavras.size)
        } while (indicesVisitados.contains(index))
        indicesVisitados.add(index)
        return index
    }
    private fun addIndexToVisitedList(index: Int) {
        indicesVisitados.add(index)
    }
}
