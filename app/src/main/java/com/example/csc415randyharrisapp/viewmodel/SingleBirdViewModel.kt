package com.example.csc415randyharrisapp.viewmodel

import android.util.Log
import com.example.csc415randyharrisapp.data.repository.BirdRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csc415randyharrisapp.data.model.NuthatchSingleResponse
import com.example.csc415randyharrisapp.model.Bird
import com.example.csc415randyharrisapp.ui.adapter.BirdAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SingleBirdViewModel @Inject constructor( private val birdRepository: BirdRepository
) : ViewModel() {
    private val _bird = MutableStateFlow<BirdEvent>(BirdEvent.Loading)
    val bird: StateFlow<BirdEvent> = _bird

    fun getBirdById(id: Int) = viewModelScope.launch {
        when( val result = birdRepository.getBird(id)){
            NuthatchSingleResponse.Failure -> {_bird.value = BirdEvent.Failure
                Log.d("getBirdById", "This is the bird: $result")}
            is NuthatchSingleResponse.Success -> {
                _bird.value = BirdEvent.Success(result.bird)
                Log.d("During Job Run", "This is the bird (success!): " + result.bird.name)}
        }
    }

    sealed class BirdEvent{
        data class Success(val bird: Bird) : BirdEvent()

        object Failure: BirdEvent()

        object Loading: BirdEvent()
    }
}