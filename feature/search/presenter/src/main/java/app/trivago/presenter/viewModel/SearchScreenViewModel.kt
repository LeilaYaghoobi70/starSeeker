package app.trivago.presenter.viewModel

import androidx.lifecycle.ViewModel
import app.trivago.domain.command.SearchCommandExecute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchCommandExecute: SearchCommandExecute,
) : ViewModel() {

    private suspend fun search() {
        searchCommandExecute.getCharactersDetails("dg")
    }
}
