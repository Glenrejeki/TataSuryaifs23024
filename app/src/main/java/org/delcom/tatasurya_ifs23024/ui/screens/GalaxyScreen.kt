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
fun GalaxyScreen(
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToSolarSystem: () -> Unit,
    currentRoute: String
) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.galaxy)
            )
        },
        bottomBar = {
            BottomNavComponent(
                currentRoute = currentRoute,
                onItemSelected = { route ->
                    when (route) {
                        "home" -> onNavigateToHome()
                        "solar_system" -> onNavigateToSolarSystem()
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
            items(SpaceDataSource.getGalaxies()) { galaxy ->
                Card(
                    onClick = { onNavigateToDetail(galaxy.id) },
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
                            text = stringResource(galaxy.nameRes),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(galaxy.descriptionRes),
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 3
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "📏 ${galaxy.diameter}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}