package br.com.deliz.correios.api.exception

class CorreiosServicoSoapException : RuntimeException {

    constructor(mensagem: String?, e: Exception?) : super(mensagem, e)
    constructor(mensagem: String?) : super(mensagem)

    companion object {
        private const val serialVersionUID = 3322940931807509294L
    }
}