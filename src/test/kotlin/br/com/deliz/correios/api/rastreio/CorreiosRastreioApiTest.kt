package br.com.deliz.correios.api.rastreio

import br.com.deliz.correios.api.rastreio.enums.CorreiosEscopoResultado
import br.com.deliz.correios.api.rastreio.enums.CorreiosIdioma
import br.com.deliz.correios.api.rastreio.model.DetalhesRastreio
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CorreiosRastreioApiTest {

    @BeforeEach
    fun enableLog(){
        com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump = true
    }

    @Test
    fun executaConsultaNaApi(){
        val correiosRastreioApi = CorreiosRastreioApi.Builder()
                .addCodigoRastreio("OD646821689BR")
                .idiomaRetorno(CorreiosIdioma.PORTUGUES)
                .escopoResposta(CorreiosEscopoResultado.TODOS_OS_EVENTOS)
                .build()

        val response: DetalhesRastreio? = correiosRastreioApi.consulta()

        assertNotNull(response)
    }

}