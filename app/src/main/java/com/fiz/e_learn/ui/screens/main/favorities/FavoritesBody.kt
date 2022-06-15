package com.fiz.e_learn.ui.screens.main.favorities

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.Category
import com.fiz.e_learn.domain.models.categoriesStore
import com.fiz.e_learn.domain.models.resourceMapCategories
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.theme.*

@Composable
fun FavoritesBody(
    categories: List<Category> = categoriesStore
) {
    MainColumn {
        for (category in categories) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colors.surface2
                    )
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val iconId = resourceMapCategories[category.iconResourceMap]
                iconId?.let {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = it),
                        contentDescription = null,
                        tint = MaterialTheme.colors.greenText
                    )
                }
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp),
                    text = category.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1
                )
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.favorites_ic_next),
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
private fun Preview() {
    ELearnTheme {
        Surface {
            FavoritesBody()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
private fun DarkPreview() {
    ELearnTheme {
        Surface {
            FavoritesBody()
        }
    }
}