package br.com.deliz.correios.api.exception

class CorreiosEventosConverterException(mensagem: String?, e: Exception?) : RuntimeException(mensagem, e) {
    companion object {
        private const val serialVersionUID = 3436745761184137500L
    }
}