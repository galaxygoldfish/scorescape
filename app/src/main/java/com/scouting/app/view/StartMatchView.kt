package com.scouting.app.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.scouting.app.MainActivity
import com.scouting.app.NavDestination
import com.scouting.app.R
import com.scouting.app.components.BasicInputField
import com.scouting.app.components.MediumButton
import com.scouting.app.theme.NeutralGrayLight
import com.scouting.app.utilities.getViewModel
import com.scouting.app.viewmodel.InMatchViewModel
import com.scouting.app.components.LargeHeaderBar
import com.scouting.app.components.RatingBar
import com.scouting.app.components.SpacedRow
import com.scouting.app.theme.AffirmativeGreen

@Composable
fun StartMatchView(navController: NavController) {
    val context = navController.context
    val viewModel = context.getViewModel(InMatchViewModel::class.java)
    val itemSpacing = 50.dp
    LaunchedEffect(true) {
        viewModel.loadTemplateItems(context as MainActivity)
    }
    Surface {
        Column {
            LargeHeaderBar(
                title = stringResource(id = R.string.start_match_header_title),
                navController = navController
            )
            SpacedRow(modifier = Modifier.padding(top = itemSpacing)) {
                Text(
                    text = stringResource(id = R.string.start_match_match_number_text),
                    style = MaterialTheme.typography.h6
                )
                BasicInputField(
                    hint = viewModel.currentMatchMonitoring.value.text,
                    textFieldValue = viewModel.currentMatchMonitoring.value,
                    onValueChange = { newText ->
                        viewModel.currentMatchMonitoring.value = newText
                    },
                    icon = painterResource(id = R.drawable.ic_time),
                    modifier = Modifier.width(115.dp)
                )
            }
            SpacedRow(modifier = Modifier.padding(top = itemSpacing)) {
                Text(
                    text = stringResource(id = R.string.start_match_team_number_text),
                    style = MaterialTheme.typography.h6
                )
                BasicInputField(
                    hint = viewModel.currentTeamMonitoring.value.text,
                    textFieldValue = viewModel.currentTeamMonitoring.value,
                    onValueChange = { newText ->
                        viewModel.currentTeamMonitoring.value = newText
                    },
                    icon = painterResource(id = R.drawable.ic_machine_learning),
                    modifier = Modifier.width(125.dp)
                )
            }
            SpacedRow(modifier = Modifier.padding(top = itemSpacing)) {
                Text(
                    text = stringResource(id = R.string.start_match_alliance_selection_text),
                    style = MaterialTheme.typography.h6
                )
                RatingBar(
                    values = 2,
                    onValueChange = { value ->
                        viewModel.currentAllianceMonitoring.value = when (value) {
                            1 -> false
                            else -> true
                        }
                    },
                    customTextValues = listOf(
                        stringResource(id = R.string.start_match_alliance_label_red),
                        stringResource(id = R.string.start_match_alliance_label_blue)
                    ),
                    allianceSelectionColor = true
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = itemSpacing, end = 30.dp),
                horizontalArrangement = Arrangement.End
            ) {
                MediumButton(
                    text = stringResource(id = R.string.start_match_begin_button_text),
                    icon = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = stringResource(id = R.string.ic_arrow_forward_content_desc),
                    onClick = {
                        viewModel.resetMatchConfig()
                        navController.navigate(NavDestination.InMatch)
                    },
                    color = AffirmativeGreen
                )
            }
        }
    }
}