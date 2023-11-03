package com.abrsoftware.userapptest.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrsoftware.userapptest.domain.model.Response
import com.abrsoftware.userapptest.domain.repository.ResponceRepository
import com.abrsoftware.userapptest.domain.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val respository: ResponceRepository
) : ViewModel() {
    var state: ResponseState by mutableStateOf(ResponseState())
        private set

    fun getUserInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = respository.getUserInfo()) {
                is Resource.Succes -> {
                    val userInfo = result.data
                    state = state.copy(
                        userInfo = userInfo!!.get(0),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        userInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

}