package com.abrsoftware.userapptest.data.model

import com.google.gson.annotations.SerializedName


data class NameModel(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String,
)

data class LoginModel(
    @SerializedName("uuid") val name: String,
    @SerializedName("username") val phone: String,
    @SerializedName("password") val email: String,
)

data class DobModel(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: String
)

data class PictureMode(
    @SerializedName("medium") val medium: String
)

data class ResultMode(
    @SerializedName("name") val name: NameModel,
    @SerializedName("email") val email: String,
    @SerializedName("login") val loginModel: LoginModel,
    @SerializedName("dob") val dobModel: DobModel,
    @SerializedName("phone") val phone: String,
    @SerializedName("picture") val pictureMode: PictureMode
)

data class ResponseModel(
    @SerializedName("results") val results: List<ResultMode>,
)