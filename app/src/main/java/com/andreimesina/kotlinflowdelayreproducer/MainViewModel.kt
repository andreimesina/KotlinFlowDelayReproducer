package com.andreimesina.kotlinflowdelayreproducer

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val testFlow: Flow<String> = callbackFlow {
        send("A")
        send("B")

        awaitClose()
    }

    val observableField = ObservableField<String>()

    init {
        viewModelScope.launch {
            launch {
                try {
                    testFlow.collect { letter ->
                        delay(2000)
                        observableField.set(letter)
                    }
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }
    }
}