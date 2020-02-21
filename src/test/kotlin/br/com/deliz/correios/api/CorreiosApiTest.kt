package br.com.deliz.correios.api

import br.com.deliz.correios.api.rastreio.CorreiosRastreioApi
import br.com.deliz.correios.api.rastreio.model.DetalhesRastreio
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


/**
 * @author lima.joao
 * @since 19/02/2020 16:18
 */
internal class CorreiosApiTest{

    @BeforeEach
    fun enableLog(){
        com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump = true
    }

    @Test
    fun testeRastreio(){
//        sigep
//        n5f9t8
//        17000190
//        9992157880
//        0067599079
//        34028316000103




       //val postagem = api
//                .postagens(CorreiosCredenciais("sigep", "n5f9t8"))
//                .buscaCliente(ContratoEmpresa("34028316000103", "9992157880", "0067599079"))
//
//        if(postagem.isPresent){
//
//        }

//        val rastreador = api.rastreios(CorreiosCredenciais("ECT", "SRO"))
//        val rastreio = rastreador
//            .buscaRastreio()
//            .peloCodigoDeRastreio("OD646821689BR")
//            .comRetornoEmPortugues()
//            .comTodosOsEventos()
//            .detalhesRastreio
//
//        rastreio?.objetosRastreio
    }




}