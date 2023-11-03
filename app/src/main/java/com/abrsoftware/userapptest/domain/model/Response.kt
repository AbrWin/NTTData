package com.abrsoftware.userapptest.domain.model

import com.abrsoftware.userapptest.data.model.DobModel
import com.abrsoftware.userapptest.data.model.LoginModel
import com.abrsoftware.userapptest.data.model.NameModel
import com.abrsoftware.userapptest.data.model.PictureMode
import com.abrsoftware.userapptest.data.model.ResponseModel
import com.abrsoftware.userapptest.data.model.ResultMode

data class Name(
    val title: String,
    val first: String,
    val last: String,
)

data class Login(
    val name: String,
    val phone: String,
    val email: String,
)

data class Dob(
    val date: String,
    val age: String
)

data class Picture(
    val medium: String
)

data class Result(
    val name: Name,
    val email: String,
    val login: Login,
    val dob: Dob,
    val phone: String,
    val picture: Picture
)

data class Response(
    val results: List<Result>
)

fun ResponseModel.toDomain() = Response(results.map { it.toDomain() })
fun ResultMode.toDomain() = Result(
    name.toDomain(),
    email,
    loginModel.toDomain(),
    dobModel.toDomain(),
    phone,
    pictureMode.toDomain()
)

fun PictureMode.toDomain() = Picture(medium)
fun DobModel.toDomain() = Dob(date, age)
fun NameModel.toDomain() = Name(title, first, last)
fun LoginModel.toDomain() = Login(name, phone, email)