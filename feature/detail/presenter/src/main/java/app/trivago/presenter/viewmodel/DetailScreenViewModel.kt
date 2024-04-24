package app.trivago.presenter.viewmodel

import androidx.lifecycle.ViewModel

//@HiltViewModel
class DetailScreenViewModel constructor(
   // val searchCommandExecute: SearchCommandExecute
) : ViewModel() {

    suspend fun search(
        character: Character
    ) {
       // searchCommandExecute.getCharactersDetails(character)
    }
}