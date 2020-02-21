package br.com.deliz.correios.api.exception

class DataInvalidaDoEventoException(mensagem: String?) : RuntimeException(mensagem) {
    companion object {
        private const val serialVersionUID = 2776160029765603084L
    }
}