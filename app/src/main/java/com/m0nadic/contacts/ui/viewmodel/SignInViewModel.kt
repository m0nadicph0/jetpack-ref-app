package com.m0nadic.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m0nadic.contacts.data.repository.AuthenticationRepository
import com.m0nadic.contacts.util.AuthStateHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepository: AuthenticationRepository,
    private val authStateHolder: AuthStateHolder
) : ViewModel() {
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _success = MutableStateFlow(false)

    val email: Flow<String> = _email
    val password: Flow<String> = _password
    val success: Flow<Boolean> = _success

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun signIn() {
        viewModelScope.launch {
            _success.value = authRepository.signIn(
                email = _email.value,
                password = _password.value
            )
            authStateHolder.setLoggedIn(_success.value)
        }
    }
}