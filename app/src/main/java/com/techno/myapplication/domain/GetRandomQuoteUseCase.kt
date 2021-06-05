package com.techno.myapplication.domain

import com.techno.myapplication.data.QuoteRepository
import com.techno.myapplication.data.model.QuoteModel
import com.techno.myapplication.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    //operator permite invocar al metodo solo con el nombre de la instancia de la clase
    operator fun invoke(): QuoteModel?{

        val quotesFromMemory = QuoteProvider.quotesList

        return if (!quotesFromMemory.isNullOrEmpty()){
           // val randomNumber = (0..quotesFromMemory.size-1).random()
            val randomNumber = (quotesFromMemory.indices).random()
            quotesFromMemory[randomNumber]
        }else
            null

    }

}