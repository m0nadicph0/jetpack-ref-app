package com.m0nadic.contacts.ui.screen.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.m0nadic.contacts.data.repository.MockAuthRepository
import com.m0nadic.contacts.data.repository.SupabaseAuthRepository
import com.m0nadic.contacts.ui.navigation.Routes
import com.m0nadic.contacts.ui.screen.shared.AuthFooter
import com.m0nadic.contacts.ui.screen.shared.PasswordFieldWithIcon
import com.m0nadic.contacts.ui.screen.shared.TextFieldWithIcon
import com.m0nadic.contacts.ui.theme.ContactsTheme
import com.m0nadic.contacts.ui.viewmodel.SignInViewModel
import com.m0nadic.contacts.util.MockAuthStateHolder
import compose.icons.TablerIcons
import compose.icons.tablericons.Lock
import compose.icons.tablericons.Mail

@Composable
fun SignInScreen(navigationController: NavHostController, vm: SignInViewModel) {

    val email by vm.email.collectAsState(initial = "")
    val password by vm.password.collectAsState(initial = "")
    val success by vm.success.collectAsState(initial = false)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(
            "Sign In",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        TextFieldWithIcon(
            label = "Email",
            value = email,
            onValueChange = { vm.onEmailChange(it) },
            icon = TablerIcons.Mail,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
        )

        PasswordFieldWithIcon(
            label = "Password",
            value = password,
            onValueChange = { vm.onPasswordChange(it) },
            icon = TablerIcons.Lock,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            vm.signIn()
            if (success) {
                navigationController.navigate(Routes.DASHBOARD)
            }

        }) {
            Text(text = "Sign In")
        }

        AuthFooter(
            text = "Don't have an account?",
            annotatedText = "Sign Up",
            onClick = {
                navigationController.navigate(Routes.SIGNUP)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable()
fun SignInScreenPreview() {
    ContactsTheme {
        SignInScreen(
            rememberNavController(), SignInViewModel(
                MockAuthRepository(),
                MockAuthStateHolder()
            )
        )
    }
}