package com.abrsoftware.userapptest.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abrsoftware.userapptest.presentation.extentions.formatDate
import com.abrsoftware.userapptest.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var picture by remember { mutableStateOf("") }

        AsyncImage(
            modifier = Modifier
                .height(140.dp)
                .width(140.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(picture)
                .crossfade(100)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Name: "+name, fontSize = 20.sp)
        Text(text = "Email: "+email, fontSize = 20.sp)
        Text(text = "Phone: "+phone, fontSize = 20.sp)
        Text(text = "Birthdate: "+date, fontSize = 20.sp)
        Text(text = "Address: "+date, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.getUserInfo()
        }) {
            Text(text = "Load user")
        }

        if (viewModel.state.userInfo != null) {
            name = viewModel.state.userInfo!!.name.first
            phone = viewModel.state.userInfo!!.phone
            email = viewModel.state.userInfo!!.email
            date = viewModel.state.userInfo!!.email
            picture = viewModel.state.userInfo!!.picture.medium
            date = viewModel.state.userInfo!!.dob.date.formatDate()
        }
    }
}


@Preview(
    showBackground = true,
    name = "Android Button text",
    device = Devices.PIXEL_4
)
@Composable
fun PrevProfile() {

}