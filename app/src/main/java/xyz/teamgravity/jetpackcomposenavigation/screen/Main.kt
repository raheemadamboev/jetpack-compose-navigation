package xyz.teamgravity.jetpackcomposenavigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import xyz.teamgravity.jetpackcomposenavigation.R
import xyz.teamgravity.jetpackcomposenavigation.Screen

@Composable
fun Main(
    navController: NavController
) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = stringResource(id = R.string.secret)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (text.isEmpty()) return@Button
                navController.navigate(Screen.Detail.args(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.to_detail_screen))
        }
    }
}