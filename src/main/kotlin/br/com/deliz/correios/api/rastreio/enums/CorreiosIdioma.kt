package br.com.deliz.correios.api.rastreio.enums

/**
 * Enum que possui os idiomas aceitos pelo correio no momento da resposta dos Eventos
 * Cada idioma possui um código:
 * 101 - Portugues
 * 102 - Inglês
 */
enum class CorreiosIdioma(val codigoInternoDosCorreio: String) {
    PORTUGUES("101"),
    INGLES("102");
}