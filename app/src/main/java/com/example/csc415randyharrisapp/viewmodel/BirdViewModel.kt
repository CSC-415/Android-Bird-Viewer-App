package com.example.csc415randyharrisapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csc415randyharrisapp.model.Bird
import com.example.csc415randyharrisapp.data.model.BirdResponse
import com.example.csc415randyharrisapp.data.repository.BirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BirdViewModel @Inject constructor(
    private val birdRepository: BirdRepository,
) : ViewModel() {
    private val _birds = MutableStateFlow<BirdEvent>(BirdEvent.Loading)
    val birds: StateFlow<BirdEvent> = _birds

    fun fillData(){
        viewModelScope.launch {
            when ( val result = birdRepository.getBirds()){
                BirdResponse.Failure -> _birds.value = BirdEvent.Failure
                is BirdResponse.Success -> _birds.value = BirdEvent.Success(result.birds)
            }
        }
    }

    sealed class BirdEvent{
        data class Success(val birds: List<Bird>) : BirdEvent()

        object Failure: BirdEvent()

        object Loading: BirdEvent()
    }
}