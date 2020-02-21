package br.com.deliz.correios.api.rastreio

import br.com.deliz.correios.api.converter.EventosDosCorreiosToDetalheRastreioConverter
import br.com.correios.webservice.rastreio.Rastro
import br.com.deliz.correios.api.exception.CorreiosCodigoRastreioInvalidoException
import br.com.deliz.correios.api.rastreio.enums.CorreiosEscopoResultado
import br.com.deliz.correios.api.rastreio.enums.CorreiosIdioma
import br.com.deliz.correios.api.rastreio.enums.CorreiosTipoIdentificador
import br.com.deliz.correios.api.rastreio.model.DetalhesRastreio
import java.util.*

/**
 * Responsavel por chamar a API de rastreio dos Correios
 *
 */
class CorreiosRastreioApi private constructor(
        private val codigosDeRastreio: MutableList<String>? = null,
        private var idioma: CorreiosIdioma? = null,
        private var escopoResultado: CorreiosEscopoResultado? = null
) {

    private val correiosServicoRastreioApi: CorreiosServicoRastreioApi = SoapCorreiosServicoRastreioApi(Rastro().servicePort)

    fun consulta(): DetalhesRastreio? {
        if(!codigosDeRastreio.isNullOrEmpty()){
            return correiosServicoRastreioApi.buscaDetalhesRastreio(
                    codigosDeRastreio,
                    idioma,
                    escopoResultado,
                    CorreiosTipoIdentificador.LISTA_DE_OBJETOS
            )
        } else {
            throw CorreiosCodigoRastreioInvalidoException("É necessário buscar os detalhes por pelo menos um código de rastreio")
        }
    }

    private fun todosOsCodigosEstaoPreenchidos(): Boolean {
        val arrayDeCodigosDeRastreio = codigosDeRastreio!!.toTypedArray()
        return arrayDeCodigosDeRastreio.isNotEmpty()
    }

    internal class Builder{
        private val codigosDeRastreio: MutableList<String>? = ArrayList()
        private var idioma: CorreiosIdioma? = null
        private var escopoResultado: CorreiosEscopoResultado? = null

        fun porCodigoDeRastreio(codigoDeRastreio: String): Builder {
            this.codigosDeRastreio!!.add(codigoDeRastreio)
            return this
        }

        fun porCodigoDeRastreio(codigoDeRastreioList: MutableList<String>): Builder {
            codigoDeRastreioList.forEach {
                this.codigosDeRastreio?.add(it)
            }
            return this
        }

        fun comRetornoEmPortugues(): Builder {
            this.idioma = CorreiosIdioma.PORTUGUES
            return this
        }

        fun comRetornoEmIngles(): Builder {
            this.idioma = CorreiosIdioma.INGLES
            return this
        }

        fun somenteUltimoEvento(): Builder {
            this.escopoResultado = CorreiosEscopoResultado.ULTIMO_EVENTO
            return this
        }

        fun todosOsEventos(): Builder {
            this.escopoResultado = CorreiosEscopoResultado.TODOS_OS_EVENTOS
            return this
        }

        fun build(): CorreiosRastreioApi {
            return CorreiosRastreioApi(codigosDeRastreio, idioma, escopoResultado)
        }
    }

}