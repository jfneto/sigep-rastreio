package br.com.deliz.correios.api.rastreio.enums

/**
 * Definição de como a lista de identificadores de objetos deverá ser interpretada pelo servidor SRO.
 * L: lista de objetos. O servidor fará a consulta individual de cada identificador informado;
 * F: intervalo de objetos. O servidor fará a consulta sequencial do primeiro ao último objeto informado,
 *
 */
enum class CorreiosTipoIdentificador(val codigoInternoDosCorreios: String) {
    LISTA_DE_OBJETOS("L"),
    INTERVALO_DE_OBJETOS("F");

}