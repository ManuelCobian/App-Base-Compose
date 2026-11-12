package com.luvsoft.ecommercekt.presentation.screens.auth.login.componets

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luvsoft.base.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import com.luvsoft.base.ui.componets.DefaultButton
import com.luvsoft.base.ui.componets.DefaultTextField
import com.luvsoft.ecommercekt.presentation.navigations.screen.AuthScreen
import com.luvsoft.ecommercekt.presentation.screens.auth.login.LoginViewmodel

@Composable
internal fun LoginContent(paddingValues: PaddingValues, navController: NavHostController, vm: LoginViewmodel = hiltViewModel()) {

    val stateForm = vm.stateForm
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMesage) {
        if (vm.errorMesage.isNotEmpty()) {
            Toast.makeText(context, vm.errorMesage, Toast.LENGTH_SHORT).show()
            vm.errorMesage = ""
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de Fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f)
            })
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo"
            )
            Text(text = "Ecommerce App",
                modifier = Modifier.padding(top = 7.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.6f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = stringResource(R.string.title_label),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = stateForm.email,
                        onValueChange = {
                            vm.onEmailInput(it)
                        },
                        label = stringResource(R.string.email_label),
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = stateForm.password,
                        hideText = true,
                        onValueChange = { text ->
                            vm.onPasswordInput(text)
                        },
                        label = stringResource(R.string.contrasena_label),
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = stringResource(R.string.login_button),
                        onClick = {
                            Log.d("click ", "yes")
                            vm.login()
                        },
                        color = Color.Blue,
                        icon = Icons.Default.ArrowForward
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {

                        Text("No tienes Cuenta?")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.clickable{
                                navController.navigate(AuthScreen.Register.route)

                            },
                            text = "Registrate",
                            color = Color.Blue,
                        )
                    }
                }
            }
        }
    }
}