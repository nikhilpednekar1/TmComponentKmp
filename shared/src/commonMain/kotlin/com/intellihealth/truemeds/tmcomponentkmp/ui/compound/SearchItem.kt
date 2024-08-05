package com.intellihealth.truemeds.tmcomponentkmp.ui.compound

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import coil.compose.AsyncImage
//import coil.request.ImageRequest
import com.intellihealth.truemeds.tmcomponentkmp.model.ProductInfoModel
import com.intellihealth.truemeds.tmcomponentkmp.ui.atom.TextS12
import com.intellihealth.truemeds.tmcomponentkmp.ui.atom.TextS16
import com.intellihealth.truemeds.tmcomponentkmp.utils.getDecimalAndFraction


@Composable
fun SearchItem(productInfoModel: ProductInfoModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Card(
            border = BorderStroke(2.dp,Color(0xFFEDEEF1)),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White,
//            ),
            shape = RoundedCornerShape(16.dp),

            ) {
            Row(Modifier.padding(16.dp)) {

//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(productInfoModel.product.productImageUrl)
//                        //.error(R.drawable.product_icon) // Fallback image when load fails
//                        //.placeholder(R.drawable.product_icon) // Placeholder while loading
//                        .build(),
//                    contentDescription = "Product Image",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.size(60.dp)
//                )
                Column {
                    TextS16(
                        productInfoModel.product.skuName,
                        FontWeight.Bold,
                        Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp)
                    )
                    TextS12(
                        productInfoModel.product.manufacturerName,
                        FontWeight.Medium,
                        Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp)
                    )
                    TextS12(
                        productInfoModel.product.packForm,//"Strip of 15 tablets",
                        FontWeight.Medium,
                        Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp)
                    )

                    Row {
                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 4.dp, end = 0.dp),
                            text = "₹"+productInfoModel.product.mrp.toString(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                        )
                        TextS12(
                            productInfoModel.product.discount.toString() + " %",
                            FontWeight.Bold,
                            Modifier.padding(start = 4.dp, top = 4.dp, end = 16.dp),
                            color = Color(0xFF178755)
                        )


                    }

                    val decFraction = getDecimalAndFraction(productInfoModel.product.sellingPrice.toString())
                    CurrencyText(decFraction.first, decFraction.second)




                }
            }

        }

        var quantity by remember { mutableIntStateOf(0) }

        Card(
            border = if (quantity == 0) BorderStroke(2.dp,Color(0xFF96BAF0)) else null,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White)
                .align(Alignment.BottomEnd)
                .width(96.dp)
                .height(40.dp),
            shape = RoundedCornerShape(12.dp),

            ) {
            Row(
                modifier = Modifier
                    .background(Color.Blue)//Color.Gray.copy(alpha = 0.1f)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                if (quantity > 0) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.trash),
//                        contentDescription = "delete",
//                        modifier = Modifier
//                            .size(16.dp)
//                            .clickable {
//                                quantity -= 1
//                            },
//                        //contentScale = ContentScale.Crop // Adjust content scale as needed
//                    )

                    // Display quantity
                    Text(
                        text = quantity.toString(),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )



//                    Icon(
//                        painter = painterResource(id = R.drawable.plus),
//                        contentDescription = "delete",
//                        modifier = Modifier
//                            .size(16.dp)
//                            .clickable {
//                                quantity += 1
//                            },
////                        contentScale = ContentScale.Crop
//                    )
                } else {
                    Row(
                        modifier = Modifier
                            .background(Color(0xFFF4FAFF)/*Color.White*/)
                            .fillMaxSize()
                            .clickable {
                                quantity += 1
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Add",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color(0xFF1B69DE),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }

            }

        }
    }

}
@Composable
fun CurrencyText(decimal: String, fraction:String) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 16.sp, color = Color(0xFF333333))) {
            append("₹${decimal}.")
        }
        withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFF333333))) {
            append(fraction)
        }
    }

    /*TextS16(
        annotatedString.text,
        FontWeight.Bold,
        Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp),
        color = Color.Black
    )*/
    Text(
        text = annotatedString,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp)
    )
}
