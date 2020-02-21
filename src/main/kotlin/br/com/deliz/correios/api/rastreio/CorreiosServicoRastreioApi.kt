package br.com.deliz.correios.api.rastreio

import br.com.deliz.correios.api.rastreio.enums.CorreiosEscopoResultado
import br.com.deliz.correios.api.rastreio.enums.CorreiosIdioma
import br.com.deliz.correios.api.rastreio.enums.CorreiosTipoIdentificador
import br.com.deliz.correios.api.rastreio.model.DetalhesRastreio

interface CorreiosServicoRastreioApi {

    fun buscaDetalhesRastreio(
            codigosDeRastreio: List<String?>?,
            idioma: CorreiosIdioma?,
            resultado: CorreiosEscopoResultado?,
            tipoIdentificador: CorreiosTipoIdentificador
    ): DetalhesRastreio?

}