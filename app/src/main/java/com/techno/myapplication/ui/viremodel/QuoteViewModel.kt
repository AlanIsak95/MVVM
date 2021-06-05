package com.techno.myapplication.ui.viremodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techno.myapplication.data.model.QuoteModel
import com.techno.myapplication.domain.GetQuotesUseCase
import com.techno.myapplication.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel :ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {

        viewModelScope.launch {

            isLoading.postValue(true)

            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }

    }

    fun randomQuote(){
        isLoading.postValue(true)

//        val currentQuote = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
        val quote = getRandomQuoteUseCase()

        quote?.let{ quoteModel.postValue(it) }

        isLoading.postValue(false)

    }


}