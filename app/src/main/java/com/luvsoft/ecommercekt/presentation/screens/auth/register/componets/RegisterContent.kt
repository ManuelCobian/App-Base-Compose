package com.luvsoft.ecommercekt.presentation.screens.auth.register.componets
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luvsoft.base.R
import com.luvsoft.base.ui.componets.DefaultButton
import com.luvsoft.base.ui.componets.DefaultTextField
import com.luvsoft.kotlinecommerce.presentation.screens.auth.register.RegisterForm
import com.luvsoft.kotlinecommerce.presentation.screens.auth.register.RegisterViewModel

@Composable
internal fun RegisterContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: RegisterViewModel = hiltViewModel()
) {
    val stateForm = vm.stateForm
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMesage) {
        if (vm.errorMesage.isNotEmpty()) {
            Toast.makeText(context, vm.errorMesage, Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de Fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f)
            })
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(top = 20.dp),
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = "Logo"
            )
            Text(
                modifier = Modifier.padding(top = 7.dp),
                text = "Ingresa esta informacion",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.6f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Registrate",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = stateForm.name,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.NAME)
                        },
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = stateForm.app,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.APP)
                        },
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value =  stateForm.email,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.EMAIL)
                        },
                        label = "Correo Electronico",
                        icon = Icons.Outlined.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = stateForm.phone,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.PHONE)
                        },
                        label = "Telefono",
                        icon = Icons.Outlined.Phone,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value =  stateForm.password,
                        hideText = true,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.PASSWORD)
                        },
                        label = "Contraseña",
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = stateForm.confirmPassword,
                        hideText = true,
                        onValueChange = {
                            vm.onRegisterInput(it, RegisterForm.CONFIRM_PASSWORD)
                        },
                        label = "Confirmar Contraseña",
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "Registrar",
                        onClick = { },
                        color = Color.Blue,
                        icon = Icons.Default.ArrowForward
                    )
                }
            }
        }
    }
}

