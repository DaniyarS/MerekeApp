package dev.dslam.merekeapp.presentation.viewModels

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(private val appRepository: AppRepository, private val sharedPref: SharedPreferences) : ViewModel() {

    private val _state = MutableLiveData<SignInState>()
    val state: LiveData<SignInState> get() = _state

    fun dispatch(action: SignInAction) {
        when(action) {
            is SignInAction.SignIn -> signIn(action.email, action.password)
            is SignInAction.SaveToken -> saveToken(action.token)
        }
    }

    private fun signIn(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
//                val result = appRepository.signIn(email, password)
//                if (result.isSuccessful) {
                    _state.postValue(SignInState.SignResponse("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjg2MTU4NjU2LCJqdGkiOiI0ZTE0MmY0ZDNkZTU0OTFiYjY0OGZiYzU2NWYyNzFhMyIsInVzZXJfaWQiOiI0NjIzOWQzNC0zNzgwLTRjZTEtOGZiOS0xZGI4NDNlOGNhMWMifQ.SVCCKLFEKlRjVTxg78uq4skpDA9PYKKsvDnUwYq6xW8"))
//                } else {
//                    _state.postValue(SignInState.SignErrorResponse("Неверные данные попробуйте заново"))
//                }
            }
        }
    }

    private fun saveToken(token: String) {
        sharedPref.edit{
            putString(Constants.USER_TOKEN, token)
        }
        _state.postValue(SignInState.TokenSaved)
    }
}

sealed class SignInAction {
    data class SignIn(
        val email: String,
        val password: String
    ) : SignInAction()

    data class SaveToken(
        val token: String
    ) : SignInAction()
}

sealed class SignInState {
    data class SignResponse(
        val token: String
    ) : SignInState()

    data class SignErrorResponse(
        val error: String?
    ) : SignInState()

    object TokenSaved : SignInState()
}