package br.com.deliz.correios.api.converter

import br.com.deliz.correios.api.rastreio.model.*
import br.com.correios.webservice.rastreio.Destinos
import br.com.correios.webservice.rastreio.Eventos
import br.com.correios.webservice.rastreio.EventosDosCorreios
import br.com.correios.webservice.rastreio.Objeto

/**
 * Classe responsavel por converter o objeto de Eventos que sao retornado pelos Correios
 *
 * @see DetalhesRastreio
 */
object EventosDosCorreiosToDetalheRastreioConverter : Converter<EventosDosCorreios?, DetalhesRastreio?> {

    override fun convert(from: EventosDosCorreios?): DetalhesRastreio? {
        val detalhesRastreio = DetalhesRastreio()
        detalhesRastreio.quantidade = Integer.valueOf(from!!.qtd)
        detalhesRastreio.versao = from.versao
        for (objeto in from.objeto!!) {
            val objetoRastreio = converteOsDadosDoPacote(objeto)
            for (eventoDoCorreio in objeto.evento!!) {
                val evento = converteDadosDoLocalDoEvento(eventoDoCorreio)
                for (destino in eventoDoCorreio.destino!!) {
                    val destinoDoPacote = converteDestinoDoEvento(destino)
                    evento.adicionaDestino(destinoDoPacote)
                }
                objetoRastreio.eventos.add(evento)
            }
            detalhesRastreio.adicionaObjetoRastreio(objetoRastreio)
        }
        return detalhesRastreio
    }

    private fun converteOsDadosDoPacote(objeto: Objeto): ObjetoRastreio {
        val objetoRastreio = ObjetoRastreio()
        objetoRastreio.numero = objeto.numero
        objetoRastreio.sigla = objeto.sigla
        objetoRastreio.nome = objeto.nome
        objetoRastreio.categoria = objeto.categoria
        objetoRastreio.descricaoErro = objeto.erro
        return objetoRastreio
    }

    private fun converteDestinoDoEvento(destino: Destinos): Destino {
        val localDoDestino =
                LocalDoPacote(destino.local!!, destino.codigo!!, destino.cidade!!, destino.bairro!!, destino.uf!!)
        return Destino(localDoDestino)
    }

    private fun converteDadosDoLocalDoEvento(eventoDoCorreios: Eventos): Evento {
        val evento = Evento()
        evento.tipo = eventoDoCorreios.tipo
        evento.status = eventoDoCorreios.status
        evento.hora = eventoDoCorreios.hora
        evento.descricao = eventoDoCorreios.descricao
        evento.detalhe = eventoDoCorreios.detalhe
        if (!eventoDoCorreios.data.isNullOrBlank()) {
            val data = FormatadorData.formataComPadraoDosCorreios(eventoDoCorreios.data)
            evento.data = data
        }
        val localDoPacote = LocalDoPacote(
                eventoDoCorreios.local ?: "",
                eventoDoCorreios.codigo ?: "",
                eventoDoCorreios.cidade ?: "",
                "",
                eventoDoCorreios.uf ?: ""
        )
        evento.local = localDoPacote
        return evento
    }


}