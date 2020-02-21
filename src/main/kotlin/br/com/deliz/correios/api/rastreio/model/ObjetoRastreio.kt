package br.com.deliz.correios.api.rastreio.model


import java.util.*

class ObjetoRastreio {

    var numero: String? = null

    var sigla: String? = null

    var nome: String? = null

    var categoria: String? = null

    var descricaoErro: String? = null

    val eventos: MutableList<Evento> = ArrayList()

    val quantidadeDeEventosOcorridos: Int
        get() = if (eventos.size > 0) eventos.size else 0

    val primeiroEvento: Evento
        get() = eventos.first()?:Evento()

    val ultimoEvento: Evento
        get() = eventos.last() ?: Evento()

    override fun toString(): String {
        return "${javaClass.name}{numero=$numero, sigla=$sigla, nome=$nome, categoria=$categoria, descricaoErro=$descricaoErro, eventos=${eventos.toString()} }"
    }
}