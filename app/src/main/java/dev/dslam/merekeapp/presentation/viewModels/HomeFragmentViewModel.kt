package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.LoadingState
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeFragmentViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    val newVenueList = appRepository.newVenueList
    val newSingersList = appRepository.newSingerList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                appRepository.refresh()
                _loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
            }
        }
    }

    private fun getVenueList() {
//        postValue(listOf(
//            Venue(
//                1,
//                "Royal Tulip",
//                "Банкетный зал вместимостью 400 человек",
//                4.5f,
//                "Макатаева 42",
//                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/37841494.jpg?k=4dba455b83c267f00babee749851e06cc836aeb069fc10428855bc5b6a9ba3fa&o=&hp=1"
//            ),
//            Venue(
//                2,
//                "Assem Toikhana",
//                "Банкетный зал вместимостью 200 человек",
//                4.8f,
//                "Толе Би 74",
//                "https://realkz.com/images_resize/main/64759.jpg"
//            )
//        ))
    }
}
