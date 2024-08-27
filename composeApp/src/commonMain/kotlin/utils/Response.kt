package utils


/* Created by Hanif on 18/04/24 */

sealed class Response<out T : Any> {
    data class Success<out T : Any>(val data: T) : Response<T>()
    data class Error(val exception: Exception) : Response<Nothing>()
    object Loading : Response<Nothing>()
}