package com.example.green_mlm_project.mngega_feature.presentaion.utli

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreference @Inject constructor(@ApplicationContext val context: Context) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

    companion object {
        val LOGIN_CODE = intPreferencesKey("login_code")
        val PRIMARY_ID = intPreferencesKey("primary_id")
    }

    val readLoginCode: Flow<Int> = context.dataStore.data
       /* .catch {
            if(this is Exception){
                emit(emptyPreferences())
            }
        }*/
        .map { preferences ->
            // No type safety.
            preferences[LOGIN_CODE] ?: -1
        }
    val readPrimaryID: Flow<Int> = context.dataStore.data
        /* .catch {
             if(this is Exception){
                 emit(emptyPreferences())
             }
         }*/
        .map { preferences ->
            // No type safety.
            preferences[LOGIN_CODE] ?: -1
        }

    suspend fun saveLoginCode(loginCode:Int?) {
        if(loginCode!=null){
            context.dataStore.edit { user ->
                user[LOGIN_CODE] = loginCode
            }
        }
    }
    suspend fun savePrimaryId(primaryID:Int?) {
        if(primaryID!=null){
            context.dataStore.edit { user ->
                user[PRIMARY_ID] = primaryID
            }
        }else{
            context.dataStore.edit { user ->
                user[PRIMARY_ID] = -1
            }
        }
    }
}