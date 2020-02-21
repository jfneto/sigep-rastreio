package br.com.deliz.correios.api.rastreio.model

class LocalDoPacote(
    var nome: String,
    var codigo: String,
    var cidade: String,
    var bairro: String,
    var uf: String
) {
    override fun toString(): String {
        return "${javaClass.name}{nome=$nome, codigo=$codigo, cidade=$cidade, bairro=$bairro, uf=$uf}"
    }
}