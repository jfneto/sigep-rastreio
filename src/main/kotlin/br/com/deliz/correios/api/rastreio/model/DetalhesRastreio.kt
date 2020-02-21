package br.com.deliz.correios.api.rastreio.model

import java.util.*

class DetalhesRastreio {

    var versao: String? = null

    var quantidade: Int? = null

    var objetosRastreio: MutableList<ObjetoRastreio> = ArrayList()

    fun adicionaObjetoRastreio(objetoRastreio: ObjetoRastreio) {
        objetosRastreio.add(objetoRastreio)
    }

    override fun toString(): String {
        return "DetalhesRastreio [versao=$versao, quantidade=$quantidade, objetosRastreio=$objetosRastreio]"
    }
}