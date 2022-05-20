package com.example.green_mlm_project.mngega_feature.presentaion.utli

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun Context.checkConnection(): Flow<Boolean> = callbackFlow {
    val callback= object :ConnectivityManager.NetworkCallback(){
        override fun onAvailable(network: Network) {
            super.onAvailable(network)

            trySend(true)

        }

        override fun onLost(network: Network) {
            super.onLost(network)
            trySend(false)
        }
    }

    val connectivityManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
    connectivityManager.requestNetwork(
        NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build(),callback)

    awaitClose { connectivityManager.unregisterNetworkCallback(callback) }

}