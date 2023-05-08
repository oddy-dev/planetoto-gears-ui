package com.planetoto.customer_component.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.planetoto.customer_component.R
import com.planetoto.customer_component.foundation.PlanetColors
import com.planetoto.customer_component.foundation.PlanetTypography

@Composable
fun PlanetToolbar(
    title: String,
    backgroundColor: PlanetColors.Solid = PlanetColors.Solid.blue07,
    showNavigateUp: Boolean = false,
    navigateUpIcon: @Composable () -> Unit = {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left_16),
            contentDescription = "up",
            tint = PlanetColors.Solid.neutralWhite.color,
            modifier = Modifier.size(24.dp)
        )
    },
    onNavigateUp: (() -> Unit)? = null
) {
    PlanetToolbar(
        title = {
            PlanetText(
                text = title,
                color = PlanetColors.Solid.neutralWhite,
                typography = PlanetTypography.TitleBody,
                maxLines = 1
            )
        },
        backgroundColor = backgroundColor,
        showNavigateUp = showNavigateUp,
        navigateUpIcon = navigateUpIcon,
        onNavigateUp = onNavigateUp
    )
}

@Composable
fun PlanetToolbar(
    title: @Composable () -> Unit,
    backgroundColor: PlanetColors.Solid = PlanetColors.Solid.blue07,
    showNavigateUp: Boolean = false,
    navigateUpIcon: @Composable () -> Unit = {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left_16),
            contentDescription = "up",
            tint = PlanetColors.Solid.neutralWhite.color,
            modifier = Modifier.size(24.dp)
        )
    },
    onNavigateUp: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor.color)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .heightIn(min = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showNavigateUp) {
            if (onNavigateUp == null) throw IllegalArgumentException("must implement onNavigateUp!")
            IconButton(
                onClick = onNavigateUp,
                content = navigateUpIcon,
                modifier = Modifier.padding(end = 10.dp)
            )
        }

        title()
    }
}