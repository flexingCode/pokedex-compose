package com.example.mypokedex.core.utilities

import android.util.Log

object UriUtilities {
    fun getIdFromUri(string: String):Int{
        try {
            val parts = string.split("/")
            val id = parts[parts.size - 2]
            return id.toInt()
        }catch(e:Exception){
            Log.e("Utilities", e.message ?: "Error en utilities")
            return 0
        }
    }
}