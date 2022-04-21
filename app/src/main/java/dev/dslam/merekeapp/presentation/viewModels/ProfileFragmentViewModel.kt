package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.UserMenu

class ProfileFragmentViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _state = MutableLiveData<ProfileState>()
    val state: LiveData<ProfileState> = _state

    fun dispatch(action: ProfileAction) {
        when (action) {
            is ProfileAction.GetUserMenu -> showUserMenuList()
            is ProfileAction.GetUserData -> showUserData()
        }
    }

    private fun showUserData() = with(_state.value) {
        ProfileState.Loading(true)

        ProfileState.Loading(false)
    }

    private fun showUserMenuList() = with(_state.value) {
        ProfileState.Loading(true)
        ProfileState.ShowUserMenu(generateUserMenuList())
        ProfileState.Loading(false)
    }

    private fun generateUserMenuList(): List<UserMenu> {
        val userMenuList = mutableListOf<UserMenu>()

        with(userMenuList) {
            add(0, UserMenu(R.drawable.ic_user, R.string.str_user_private_data))
            add(1, UserMenu(R.drawable.ic_favorite_star, R.string.str_user_favorites))
            add(2, UserMenu(R.drawable.ic_phone, R.string.str_user_techsupport))
            add(3, UserMenu(R.drawable.ic_basket, R.string.str_user_order_history))
            add(4, UserMenu(R.drawable.ic_faq, R.string.str_user_faq))
            add(5, UserMenu(R.drawable.ic_circled_info, R.string.str_user_about_app))
        }

        return userMenuList
    }
}

sealed class ProfileAction {
    object GetUserMenu : ProfileAction()
    object GetUserData : ProfileAction()
}

sealed class ProfileState {
    data class Loading(val show: Boolean) : ProfileState()
    data class ShowUserMenu(val userMenuList: List<UserMenu>) : ProfileState()
}