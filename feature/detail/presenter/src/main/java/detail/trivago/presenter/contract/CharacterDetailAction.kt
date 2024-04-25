package detail.trivago.presenter.contract

import detail.trivago.presenter.model.Character

data class CharacterDetailAction(
    val getDetail: (Character) -> Unit = {},
)
