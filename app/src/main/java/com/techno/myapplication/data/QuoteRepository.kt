package com.techno.myapplication.data

import com.techno.myapplication.data.model.QuoteModel
import com.techno.myapplication.data.model.QuoteProvider
import com.techno.myapplication.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{

        val response = api.getQuotes()
        QuoteProvider.quotesList = response

        return response

    }

}