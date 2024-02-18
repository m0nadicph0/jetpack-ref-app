package com.m0nadic.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.m0nadic.contacts.ui.navigation.Navigation
import com.m0nadic.contacts.ui.theme.ContactsTheme
import com.m0nadic.contacts.util.AuthStateHolderImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsTheme {
                Navigation(this)
            }
        }
    }
}

