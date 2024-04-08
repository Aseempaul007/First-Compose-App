package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun MyText() {
    Text(
        text = "Aseem Paul has a great heart and soul",
        color = Color.Blue,
        fontSize = 28.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
        maxLines = 1,
        softWrap = true,
        overflow = TextOverflow.Clip,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.heart),
        contentDescription = "Dummy",
        alignment = Alignment.BottomCenter,
        colorFilter = ColorFilter.tint(Color.Black),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyButton() {
    Button(
        onClick = { },
        shape = ButtonDefaults.outlinedShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Red
        )
    ) {
        Text("Aseem Paul")
        Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "Dumb"
        )
    }
}

@Composable
fun MyTextField() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(text = "Enter email")
        }
    )
}

@Composable
fun MyColumn() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Aseem")
        Text(text = "Anu")
    }
}

@Composable
fun MyRow() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "Aseem")
        Text(text = "Anu")
    }
}

@Composable
fun MyBox() {
    Box(
        contentAlignment = Alignment.BottomStart
    ) {
        Text(text = "Aseem")
        Text(text = "Anu")
    }
}

@Composable
fun ListViewItem(image: Int, name: String, designation: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
    ) {
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = image),
            contentDescription = "User"
        )
        Column(
            modifier = Modifier.fillMaxHeight(),
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
}

@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
    ListViewItem(R.drawable.icon_user, "Aseem Paul", "Android eveloper")
}
