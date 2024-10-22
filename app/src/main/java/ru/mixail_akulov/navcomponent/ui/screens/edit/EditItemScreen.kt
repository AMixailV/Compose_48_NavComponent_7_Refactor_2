package ru.mixail_akulov.navcomponent.ui.screens.edit


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import ru.mixail_akulov.navcomponent.R
import ru.mixail_akulov.navcomponent.model.LoadResult
import ru.mixail_akulov.navcomponent.ui.screens.edit.EditItemViewModel.ScreenState
import ru.mixail_akulov.navcomponent.ui.screens.EditItemRoute
import ru.mixail_akulov.navcomponent.ui.EventConsumer
import ru.mixail_akulov.navcomponent.ui.components.ItemDetails
import ru.mixail_akulov.navcomponent.ui.components.ItemDetailsState
import ru.mixail_akulov.navcomponent.ui.components.LoadResultContent
import ru.mixail_akulov.navcomponent.ui.screens.LocalNavController
import ru.mixail_akulov.navcomponent.ui.screens.actions.ActionScreen
import ru.mixail_akulov.navcomponent.ui.screens.routeClass

@Composable
fun EditItemScreen(index: Int) {
    val viewModel = hiltViewModel<EditItemViewModel, EditItemViewModel.Factory> { factory ->
        factory.create(index)
    }
    ActionScreen(
        delegate = viewModel,
        content = { (screenState, onExecuteAction) ->
            SuccessEditItemContent(screenState, onExecuteAction)
        }
    )
}

@Composable
private fun SuccessEditItemContent(
    state: ScreenState,
    onEditButtonClicked: (String) -> Unit
) {
    ItemDetails(
        state = ItemDetailsState(
            loadedItem = state.loadedItem,
            textFieldPlaceholder = stringResource(id = R.string.enter_new_item),
            actionButtonText = stringResource(id = R.string.add),
            isActionInProgress = state.isEditInProgress
        ),
        onActionButtonClicked = onEditButtonClicked,
        modifier = Modifier.fillMaxSize()
    )
}