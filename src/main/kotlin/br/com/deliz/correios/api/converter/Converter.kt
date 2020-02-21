package br.com.deliz.correios.api.converter

/**
 * Interface para converção de um Objeto(F) para outro Objeto(T)
 */
interface Converter<F, T> {
    fun convert(from: F): T
}