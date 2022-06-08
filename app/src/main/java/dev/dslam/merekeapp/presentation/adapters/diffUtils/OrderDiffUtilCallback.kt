package dev.dslam.merekeapp.presentation.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.Order

class OrderDiffUtilCallback : DiffUtil.ItemCallback<Order>() {
    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return true //oldItem.id.toString() + oldItem.description == newItem.id.toString() + newItem.description
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return true //areContentsTheSame(oldItem, newItem)
    }
}