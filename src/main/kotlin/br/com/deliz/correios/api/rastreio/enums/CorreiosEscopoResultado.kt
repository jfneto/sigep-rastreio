package br.com.deliz.correios.api.rastreio.enums

/**
 * Delimitacao do escopo da resposta a ser dada a consulta do rastreamento de cada objeto
 * T: Serao retornados todos os eventos do objeto
 * U: Sera retornado apenas o ultimo evento do objeto
 *
 */
enum class CorreiosEscopoResultado(val codigoInternoDosCorreios: String) {
    TODOS_OS_EVENTOS("T"), ULTIMO_EVENTO("U");

}