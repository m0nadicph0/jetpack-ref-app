package com.m0nadic.contacts.data.repository

import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

interface AuthenticationRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean
}

class SupabaseAuthRepository(
    private val auth: Auth
) : AuthenticationRepository {
    override suspend fun signIn(email: String, password: String): Boolean {
        return try {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e :Exception) {
            false
        }
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        return try {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            false
        }
    }

}

class MockAuthRepository: AuthenticationRepository {
    override suspend fun signIn(email: String, password: String): Boolean {
        return true
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        return true
    }

}