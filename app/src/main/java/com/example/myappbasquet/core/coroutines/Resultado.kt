package com.example.myappbasquet.core.coroutines

sealed class Resultado<T> {
    data class OnSuccess<T>(val value: T) : Resultado<T>()
    data class OnError<T>(val throwable: Throwable) : Resultado<T>()
    class OnLoading<T> : Resultado<T>()
    class OnCancel<T> : Resultado<T>()
    class OnEmpty<T> : Resultado<T>()
}