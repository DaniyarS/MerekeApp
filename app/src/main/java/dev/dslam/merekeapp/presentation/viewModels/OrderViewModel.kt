package dev.dslam.merekeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dslam.merekeapp.local.AppRepository
import dev.dslam.merekeapp.models.Order

class OrderViewModel(private val appRepository: AppRepository) : ViewModel(){

    private val _state = MutableLiveData<OrderState>()
    val state: LiveData<OrderState> get() = _state

    fun dispatch(action: OrderAction) {
        when(action) {
            is OrderAction.BookOrder -> bookOrder(action.order)
        }
    }

    private fun bookOrder(order: Order) {
        appRepository.bookOrder(order)
        _state.value = OrderState.BookOrdered
    }
}

sealed class OrderAction {
    data class BookOrder(val order: Order) : OrderAction()
}

sealed class OrderState {
    object BookOrdered: OrderState()
}