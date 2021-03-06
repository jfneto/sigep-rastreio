package br.com.deliz.correios.api.rastreio.enums

internal enum class CorreiosStatusFinal {
    BDE0, BDE1, BDE24, BDI0, BDI1, BDI24, BDR0, BDR1, BDR24, LDI1, LDI2, LDI3, LDI4, LDI14;

    companion object {
        @JvmStatic
        fun isFinal(tipo: String?, status: String?): Boolean {
            val statusConcatenado = tipo + status!!.toInt()
            for (statusFinal in values()) {
                if (statusFinal.name == statusConcatenado) {
                    return true
                }
            }
            return false
        }
    }
}