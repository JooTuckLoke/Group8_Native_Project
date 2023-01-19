package com.example.groupproject.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.groupproject.model.Item

@Composable
fun WishlistCard(item: Item, onItemClicked: (item: Item) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(item) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,


                ) {

                val image: Painter = painterResource(id = item.image)
                Image(
                    modifier = Modifier
                        .size(80.dp, 80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = image,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = item.name,
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                val delete: Painter = painterResource(id = android.R.drawable.ic_menu_delete)

                Text(
                    text = "Contact Seller",

                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.caption
                )

                    Icon(
                        painter = delete,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {  }
                            .size(20.dp, 20.dp),

                        tint = Color.Red
                    )
                }
            }
        }

}