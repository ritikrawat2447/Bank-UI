package com.example.assignment

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment.dummy.allServicesData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val topAppBar: @Composable () -> Unit = {
        TopAppBar(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .background(
                    colorResource(id = R.color.primary_color)
                ),
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Handle menu click */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.aman_bank_logo1), // Replace with your logo resource
                        contentDescription = "Logo",
                        modifier = Modifier.size(100.dp) // Adjust the size as needed
                    )
                }
            },
            colors = topAppBarColors(
                containerColor = colorResource(id = R.color.primary_color),
            ),
            scrollBehavior = scrollBehavior
        )
    }

    Scaffold(
        topBar = topAppBar,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier.padding(bottom = 130.dp),
                containerColor = Color.White
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chatbot_speech_bubble_1),
                    contentDescription = "Drawable Icon",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Image(
                    painter = painterResource(id = R.drawable.group_10804),
                    contentDescription = "Bank Image",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(250.dp, 200.dp)
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Text(
                    text = "Welcome to Aman Bank",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_color),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )


                LazyVerticalGrid(GridCells.Fixed(3), modifier = Modifier.fillMaxSize()) {
                    items(allServicesData) { services ->
                        ServicesView(icon = services.serviceIcon, title = services.serviceDetails)
                    }
                }


            }

            Column(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.primary_color),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .align(Alignment.BottomCenter)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 25.dp)
                )
                Button(
                    onClick = { navController.navigate(Screens.Home.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Text(
                        "Log In",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.primary_color),
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp)
                )
            }

        }
    }
}

@Composable
fun ServicesView(icon: Int, title: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Service Image",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

data class ServicesData(
    val serviceIcon: Int,
    val serviceDetails: String
)

object dummy {
    val allServicesData = listOf(
        ServicesData(R.drawable.wallet_43_1, "Account\nDetails"),
        ServicesData(R.drawable.vector, "Recent\nTransaction"),
        ServicesData(R.drawable.credit_card_2, "Card\nDetails"),
        ServicesData(R.drawable.credit_card_in_1, "Locate\nATM"),
        ServicesData(R.drawable.bank, "Locate\nBranch"),
        ServicesData(R.drawable._9, "Open\nAccount")
    )
}
