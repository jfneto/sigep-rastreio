package br.com.deliz.correios.credentials

import java.util.*


@Suppress("unused")
object ConfiguracoesHelper {

    private val props = Properties()

    init {
        props.clear()
        val file = javaClass.getResourceAsStream("/rastreio_correios.properties")
        props.load(file)
    }

    // CREDENCIAIS
    val USUARIO_RATREIO = props.getProperty("credenciais.rastreio.login")
    val SENHA_RATREIO = props.getProperty("credenciais.rastreio.senha")

}