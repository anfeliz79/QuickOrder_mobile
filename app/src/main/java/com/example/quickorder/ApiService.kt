package com.example.quickorder

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Simple API service to fetch pedidos.
 */
class ApiService {
    private val client = OkHttpClient()

    /**
     * Fetches the list of pedidos from the backend.
     *
     * This function executes the network call on the IO dispatcher.
     */
    suspend fun getPedidos(): String? = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url("https://example.com/pedidos")
            .build()

        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                response.body?.string()
            } else {
                null
            }
        }
    }
}
