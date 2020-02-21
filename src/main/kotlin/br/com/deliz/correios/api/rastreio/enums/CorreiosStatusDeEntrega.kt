package br.com.deliz.correios.api.rastreio.enums

internal enum class CorreiosStatusDeEntrega {
    BDE0, BDE1, BDI0, BDI1, BDR0, BDR1;

    companion object {
        @JvmStatic
        fun isEntregaRealizada(tipo: String?, status: String?): Boolean {
            val statusConcatenado = tipo + status!!.toInt()
            for (statusEntregue in values()) {
                if (statusEntregue.name == statusConcatenado) {
                    return true
                }
            }
            return false
        }
    }
}