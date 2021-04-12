package com.example.recipien.utils

sealed class Networkresult <T>(
    var data:T?=null,
    var massage:String?=null
){

    class Success<T>(data: T):Networkresult<T>(data)
    class Error<T>(massage: String?,data: T?=null):Networkresult<T>(data,massage)
    class Loading<T>:Networkresult<T>()
}