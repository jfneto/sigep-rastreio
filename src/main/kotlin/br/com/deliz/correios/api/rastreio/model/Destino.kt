package br.com.deliz.correios.api.rastreio.model

class Destino(var local: LocalDoPacote? = null) {
    override fun toString(): String {
        return "Destino [local=$local]"
    }
}