package dev.dslam.merekeapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.OrderListItemBinding
import dev.dslam.merekeapp.models.Order
import dev.dslam.merekeapp.presentation.adapters.diffUtils.OrderDiffUtilCallback

class OrderListAdapter : ListAdapter<Order, OrderListAdapter.OrderViewHolder>(
    OrderDiffUtilCallback()
) {

    val productClicked: ((Order) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        OrderViewHolder(
            OrderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) = holder.bind(getItem(position))

    inner class OrderViewHolder(private val binding: OrderListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            binding.bookNumber.text = binding.bookNumber.text.toString() + (position + 1)
            binding.orderNameTextView.text = order.name
            binding.ordersDescription.text = order.description

            binding.root.setOnClickListener {
                productClicked?.invoke(order)
            }

            Glide
                .with(binding.root)
                .load(order.image)
                .centerCrop()
                .into(binding.productImageView)

            binding.banketDayData.text = order.date
            binding.banketTimeData.text = order.time
            binding.phoneNumberData.text = order.phoneNumber
        }
    }
}
