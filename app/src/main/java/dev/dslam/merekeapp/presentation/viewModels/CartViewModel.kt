package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.Order

class CartViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _state = MutableLiveData<CartState>()
    val state: LiveData<CartState> get() = _state

    fun dispach(action: CartAction) {
        when(action) {
            is CartAction.GetOrder -> getOrders()
        }
    }

    private fun getOrders() {
        val result = appRepository.getOrders()
        _state.value = CartState.ShowOrders(result)
    }
}

sealed class CartAction{
    object GetOrder : CartAction()
}

sealed class CartState{
    data class ShowOrders(val orders : List<Order>?) : CartState()
}