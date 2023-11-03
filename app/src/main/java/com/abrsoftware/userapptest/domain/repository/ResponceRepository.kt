package com.abrsoftware.userapptest.domain.repository

import com.abrsoftware.userapptest.domain.model.Result
import com.abrsoftware.userapptest.domain.resource.Resource

interface ResponceRepository {
    suspend fun getUserInfo():Resource<List<Result>>
}