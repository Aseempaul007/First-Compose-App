package com.example.firstcomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserList() {
    LazyColumn(
        content = {
            items(getUsersList()) {user ->
                ListItem(image = user.userImage, name = user.userName, designation = user.userDesignation)
            }
        }
    )
}

@Composable
fun ListItem(image: Int, name: String, designation: String) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ){
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(id = image),
                contentDescription = "User"
            )
            ItemDescription(name, designation, Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun ItemDescription(name: String, designation: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontSize = 26.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
        Text(text = designation, fontSize = 32.sp)
    }
}

data class User(val userImage: Int, val userName: String, val userDesignation: String)

fun getUsersList(): MutableList<User> {
    val users = mutableListOf(
        User(R.drawable.icon_user, "Aseem Paul", "Android developer"),
        User(R.drawable.icon_user, "Anu Paul", "Android developer"),
        User(R.drawable.icon_user, "Punnu Paul", "Android developer"),
        User(R.drawable.icon_user, "Chunnu Paul", "Android developer"),
        User(R.drawable.icon_user, "Didu Paul", "Android developer"),
        User(R.drawable.icon_user, "Gullan Paul", "Android developer"),
        User(R.drawable.icon_user, "Bullu Paul", "Android developer"),
        User(R.drawable.icon_user, "Babbu Paul", "Android developer"),
        User(R.drawable.icon_user, "Behenji Paul", "Android developer"),
        User(R.drawable.icon_user, "Kutia Paul", "Android developer"),
        User(R.drawable.icon_user, "Kalli Paul", "Android developer"),
        User(R.drawable.icon_user, "Rama Paul", "Android developer")
    )
    return users
}
@Preview(showSystemUi = true)
@Composable
fun MyPreview2() {
    UserList()
//    ListItem(R.drawable.icon_user, "Aseem Paul", "Android developer")
}