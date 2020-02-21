package br.com.deliz.correios.api.exception

class CorreiosCodigoRastreioInvalidoException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 737499170988505334L
    }
}