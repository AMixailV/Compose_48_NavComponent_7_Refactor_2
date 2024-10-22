package ru.mixail_akulov.navcomponent.ui.screens.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.mixail_akulov.navcomponent.R
import ru.mixail_akulov.navcomponent.ui.screens.AddItemRoute
import ru.mixail_akulov.navcomponent.ui.EventConsumer
import ru.mixail_akulov.navcomponent.ui.components.ItemDetails
import ru.mixail_akulov.navcomponent.ui.components.ItemDetailsState
import ru.mixail_akulov.navcomponent.ui.screens.LocalNavController
import ru.mixail_akulov.navcomponent.ui.screens.actions.ActionScreen
import ru.mixail_akulov.navcomponent.ui.screens.add.AddItemViewModel.ScreenState
import ru.mixail_akulov.navcomponent.ui.screens.routeClass

@Composable
fun AddItemScreen() {
    val viewModel: AddItemViewModel = hiltViewModel()
    ActionScreen(
        delegate = viewModel,
        content = { (screenState, onExecuteAction) ->
            AddItemContent(screenState, onExecuteAction)
        }
    )
}

@Composable
fun AddItemContent(
    screenState: ScreenState,
    onAddButtonClicked: (String) -> Unit
) {
    ItemDetails(
        state = ItemDetailsState(
            loadedItem = "",
            textFieldPlaceholder = stringResource(id = R.string.enter_new_item),
            actionButtonText = stringResource(id = R.string.add),
            isActionInProgress = screenState.isProgressVisible
        ),
        onActionButtonClicked = onAddButtonClicked,
        modifier = Modifier.fillMaxSize()
    )
}

