package com.abrsoftware.userapptest.data.repository

import com.abrsoftware.userapptest.data.model.ResponseModel
import com.abrsoftware.userapptest.data.remote.MyApiService
import com.abrsoftware.userapptest.domain.model.Result
import com.abrsoftware.userapptest.domain.model.toDomain
import com.abrsoftware.userapptest.domain.repository.ResponceRepository
import com.abrsoftware.userapptest.domain.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ResponseRepositoryImpl @Inject constructor(
    private val api: MyApiService
) : ResponceRepository {
    override suspend fun getUserInfo(): Resource<List<Result>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getUserInfo()
                val finalResponse =  (response.body() as ResponseModel).results.map { it.toDomain() }
                Resource.Succes(
                    data = finalResponse
                )
            } catch (e: Exception) {
                Resource.Error(e.message ?: "An error")
            }
        }
    }
}