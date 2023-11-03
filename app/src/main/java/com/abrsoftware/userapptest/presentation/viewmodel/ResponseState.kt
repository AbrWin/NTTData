package com.abrsoftware.userapptest.presentation.viewmodel

import com.abrsoftware.userapptest.domain.model.Result

data class ResponseState(
    val userInfo: Result? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
