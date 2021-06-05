package com.techno.myapplication.domain

import com.techno.myapplication.data.QuoteRepository
import com.techno.myapplication.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    // operator permite invocar al metodo solo con el nombre de la instancia de la clase
    suspend operator fun invoke():List<QuoteModel> = repository.getAllQuotes()

}