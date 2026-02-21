package org.delcom.tatasurya_ifs23024.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.delcom.tatasurya_ifs23024.R
import org.delcom.tatasurya_ifs23024.data.SpaceDataSource
import org.delcom.tatasurya_ifs23024.ui.components.BottomNavComponent
import org.delcom.tatasurya_ifs23024.ui.components.TopAppBarComponent

@Composable
fun SolarSystemScreen(
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToGalaxy: () -> Unit,
    currentRoute: String
) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.solar_system)
            )
        },
        bottomBar = {
            BottomNavComponent(
                currentRoute = currentRoute,
                onItemSelected = { route ->
                    when (route) {
                        "home" -> onNavigateToHome()
                        "galaxy" -> onNavigateToGalaxy()
                        else -> {}
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.stars),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(SpaceDataSource.getStars()) { star ->
                SpaceItemCard(
                    item = star,
                    onClick = { onNavigateToDetail(star.id) }
                )
            }

            item {
                Text(
                    text = stringResource(R.string.planets),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(SpaceDataSource.getPlanets()) { planet ->
                SpaceItemCard(
                    item = planet,
                    onClick = { onNavigateToDetail(planet.id) }
                )
            }
        }
    }
}

@Composable
fun SpaceItemCard(
    item: org.delcom.tatasurya_ifs23024.data.SpaceData,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(item.nameRes),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "🌍 ${item.diameter}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "🌡️ ${item.temperature}",
                    style = MaterialTheme.typography.bodySmall
                )
                if (item.moons > 0) {
                    Text(
                        text = "🌙 ${item.moons}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}