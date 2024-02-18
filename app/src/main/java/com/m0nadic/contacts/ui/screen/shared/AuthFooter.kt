package com.m0nadic.contacts.ui.screen.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m0nadic.contacts.ui.theme.poppinsFontFamily

@Composable
fun AuthFooter(
    text: String,
    annotatedText: String,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(top = 30.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(text, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(5.dp))
        ClickableText(
            text = AnnotatedString(annotatedText),
            style = TextStyle(color = MaterialTheme.colorScheme.primary),
            onClick = onClick
        )
    }
}