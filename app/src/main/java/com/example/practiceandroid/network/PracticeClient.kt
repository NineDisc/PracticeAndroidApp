package com.example.practiceandroid.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json

class PracticeClient {
    suspend fun connect() {
        val id = 7.toString()
        val client = HttpClient() {
            install(ContentNegotiation) {
                json()
            }
//            defaultRequest {
//                url {
//                    protocol = URLProtocol.HTTPS
//                    host = "pokeapi.co"
//                    path("/api/v2/")
//                    parameters.append("","")
//                }
//            }
        }
        val response = client.get("https://pokeapi.co/api/v2/pokemon/1")
        Log.d("Practice", response.bodyAsText())
    }
}