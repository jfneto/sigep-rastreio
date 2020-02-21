package br.com.deliz.correios.api.rastreio.model

import br.com.deliz.correios.api.rastreio.enums.CorreiosStatusDeEntrega
import br.com.deliz.correios.api.rastreio.enums.CorreiosStatusFinal
import java.util.*

/**
 * Classe que contem os dados de um determinado evento ocorrido no objeto desejado
 */
class Evento(
        var tipo: String? = null,
        var status: String? = null,
        var data: Calendar? = null,
        var hora: String? = null,
        var descricao: String? = null,
        var detalhe: String? = null,
        var codigo: String? = null,
        var local: LocalDoPacote? = null
) {

    private val destinos: MutableList<Destino> = ArrayList()

    fun getDestinos(): List<Destino> {
        return Collections.unmodifiableList(destinos)
    }

    val primeiroDestino: Destino
        get() = destinos.first() ?: Destino()

    val ultimoDestino: Destino
        get() = destinos.last() ?: Destino()

    val isStatusFinal: Boolean
        get() = CorreiosStatusFinal.Companion.isFinal(tipo, status)

    val isEntregaRealizada: Boolean
        get() = CorreiosStatusDeEntrega.isEntregaRealizada(tipo, status)

    fun adicionaDestino(destinoDoPacote: Destino) {
        destinos.add(destinoDoPacote)
    }

    override fun toString(): String {
        return "${javaClass.name}{tipo=$tipo, status=$status, data=${data.toString()}, hora=$hora, descricao=$descricao, detalhe=$detalhe, codigo=$codigo, local=${local.toString()}, destinos=${destinos.toString()}}"
    }
}