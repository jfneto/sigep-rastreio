package br.com.deliz.correios.api.converter

import br.com.deliz.correios.api.exception.DataInvalidaDoEventoException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object FormatadorData {
    @JvmStatic
    fun formataComPadraoDosCorreios(data: String?): Calendar {
        val formatador = SimpleDateFormat("dd/MM/yyyy")
        val date: Date
        return try {
            date = formatador.parse(data)
            val dataDoEvento = Calendar.getInstance()
            dataDoEvento.time = date
            dataDoEvento
        } catch (e: ParseException) {
            throw DataInvalidaDoEventoException(String.format("A seguinte data retornada pelo correios é inválida: %s", data))
        }
    }
}