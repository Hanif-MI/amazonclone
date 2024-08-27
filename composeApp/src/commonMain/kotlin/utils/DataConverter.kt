package utils

import kotlinx.serialization.*
import kotlinx.serialization.json.Json


/* Created by Hanif on 21/08/24 */


// Generic function to convert any data class to a string
inline fun <reified T : Any> dataClassToString(data: T, delimiter: String = "|"): String {
    val jsonString = Json.encodeToString(data)
    return jsonString.replace(delimiter, "\\$delimiter")
}

// Generic function to convert a string back to any data class
inline fun <reified T : Any> stringToDataClass(dataString: String, delimiter: String = "|"): T {
    val jsonString = dataString.replace("\\$delimiter", delimiter)
    return Json.decodeFromString(jsonString)
}


// Generic function to convert a list of any data class to a string
inline fun <reified T : Any> listToString(dataList: List<T>, delimiter: String = "|"): String {
    val jsonString = Json.encodeToString(dataList)
    return jsonString.replace(delimiter, "\\$delimiter")
}

// Generic function to convert a string back to a list of any data class
inline fun <reified T : Any> stringToList(dataString: String, delimiter: String = "|"): List<T> {
    val jsonString = dataString.replace("\\$delimiter", delimiter)
    return Json.decodeFromString(jsonString)
}