package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.LoadingState
import kotlinx.coroutines.launch
import java.lang.Exception

class SingersFragmentViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    val allSingersList = appRepository.allSingers

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                appRepository.refreshMainPage()
                _loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
            }
        }
    }

}

//sealed class SingerDataState {
//    data class Singer(
//        val id: Int,
//        val name: String,
//        val description: String,
//        val rating: Float,
//        val images: List<Image>
//    ) : SingerDataState()
//
//    data class IsLoading(
//        val isLoading: Boolean
//    ) : SingerDataState()
//}