package com.m0nadic.contacts.util

import android.content.Context
import androidx.compose.runtime.compositionLocalOf
import androidx.core.content.edit


val LocalAuthStateHolder = compositionLocalOf<AuthStateHolderImpl> {
    error("No AuthStateHolder found!")
}


interface AuthStateHolder {
    fun isLoggedIn(): Boolean
    fun setLoggedIn(isLoggedIn: Boolean)
}

class AuthStateHolderImpl(context: Context) : AuthStateHolder {
    private val PREF_NAME = "ContactPreference"
    private val KEY_IS_LOGGED_IN = "is_logged_in"

    private val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE )

    override fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    override fun setLoggedIn(isLoggedIn: Boolean) {
        sharedPreferences.edit {
            putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        }
    }
}

class MockAuthStateHolder(): AuthStateHolder {
    override fun isLoggedIn(): Boolean {
        return true
    }

    override fun setLoggedIn(isLoggedIn: Boolean) {
        TODO("Not yet implemented")
    }

}
