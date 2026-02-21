package org.delcom.tatasurya_ifs23024.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.delcom.tatasurya_ifs23024.R
import org.delcom.tatasurya_ifs23024.data.SpaceDataSource
import org.delcom.tatasurya_ifs23024.data.SpaceType
import org.delcom.tatasurya_ifs23024.ui.components.BottomNavComponent

@Composable
fun HomeScreen(
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToSolarSystem: () -> Unit,
    onNavigateToGalaxy: () -> Unit,
    currentRoute: String
) {
    Scaffold(
        bottomBar = {
            BottomNavComponent(
                currentRoute = currentRoute,
                onItemSelected = { route ->
                    when (route) {
                        "solar_system" -> onNavigateToSolarSystem()
                        "galaxy" -> onNavigateToGalaxy()
                        else -> {}
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.welcome_to_space),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.welcome_message),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Text(
                text = stringResource(R.string.featured_items),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(SpaceDataSource.spaceItems) { item ->
                    Card(
                        onClick = { onNavigateToDetail(item.id) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = stringResource(item.nameRes),
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = stringResource(
                                        when (item.type) {
                                            SpaceType.PLANET -> R.string.planet
                                            SpaceType.STAR -> R.string.star
                                            SpaceType.GALAXY -> R.string.galaxy
                                        }
                                    ),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Text(
                                text = item.distanceFromSun,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}