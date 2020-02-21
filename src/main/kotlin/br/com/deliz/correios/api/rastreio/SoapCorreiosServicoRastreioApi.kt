package br.com.deliz.correios.api.rastreio

import br.com.deliz.correios.api.converter.EventosDosCorreiosToDetalheRastreioConverter
import br.com.deliz.correios.api.exception.CorreiosEventosConverterException
import br.com.deliz.correios.api.exception.CorreiosServicoSoapException
import br.com.deliz.correios.api.rastreio.enums.CorreiosEscopoResultado
import br.com.deliz.correios.api.rastreio.enums.CorreiosIdioma
import br.com.deliz.correios.api.rastreio.enums.CorreiosTipoIdentificador
import br.com.correios.webservice.rastreio.EventosDosCorreios
import br.com.correios.webservice.rastreio.Service
import br.com.deliz.correios.api.rastreio.model.DetalhesRastreio
import br.com.deliz.correios.api.rastreio.model.ObjetoRastreio
import br.com.deliz.correios.credentials.ConfiguracoesHelper

/**
 * Classe que encapsula a chamada SOAP para os correios atraves do WSDL dos Correios
 */
internal class SoapCorreiosServicoRastreioApi(private val servicoApi: Service) : CorreiosServicoRastreioApi {

    override fun buscaDetalhesRastreio(
            codigosDeRastreio: List<String?>?,
            idioma: CorreiosIdioma?,
            resultado: CorreiosEscopoResultado?,
            tipoIdentificador: CorreiosTipoIdentificador
    ): DetalhesRastreio? {
        val eventos: EventosDosCorreios? = try {

            if (codigosDeRastreio!!.size > 1) {
                servicoApi.buscaEventosLista(
                        ConfiguracoesHelper.USUARIO_RATREIO, ConfiguracoesHelper.SENHA_RATREIO,
                        tipoIdentificador.codigoInternoDosCorreios,
                        resultado!!.codigoInternoDosCorreios,
                        idioma!!.codigoInternoDosCorreio,
                        codigosDeRastreio
                )
            } else {
                servicoApi.buscaEventos(
                        ConfiguracoesHelper.USUARIO_RATREIO, ConfiguracoesHelper.SENHA_RATREIO,
                        tipoIdentificador.codigoInternoDosCorreios,
                        resultado!!.codigoInternoDosCorreios,
                        idioma!!.codigoInternoDosCorreio,
                        codigosDeRastreio[0]
                )
            }
        } catch (e: Exception) {
            throw CorreiosServicoSoapException(
                    "Ocorreu um erro ao fazer a chamada SOAP para os correios. Verifique se voce passou corretamente os dados desejados",
                    e
            )
        }
        val detalhesRastreio: DetalhesRastreio?
        detalhesRastreio = try {
            EventosDosCorreiosToDetalheRastreioConverter.convert(eventos)
        } catch (e: Exception) {
            throw CorreiosEventosConverterException(
                    "Ocorreu um erro ao tentar converter o Evento vindo dos correios",
                    e
            )
        }
        val objetosRastreio = detalhesRastreio!!.objetosRastreio
        if (temErroGenerico(objetosRastreio)) {
            throw CorreiosServicoSoapException(
                    String.format(
                            "Ocorreu um erro ao fazer a chamada SOAP para os correios: %s",
                            objetosRastreio[0].descricaoErro
                    )
            )
        }
        return detalhesRastreio
    }

    private fun temErroGenerico(objetosRastreio: List<ObjetoRastreio?>?): Boolean {
        return objetosRastreio!!.size == 1 && objetosRastreio[0]!!.numero == "Erro"
    }

}