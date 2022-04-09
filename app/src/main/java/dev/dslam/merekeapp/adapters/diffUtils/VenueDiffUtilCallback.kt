package dev.dslam.merekeapp.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.Venue

class VenueDiffUtilCallback : DiffUtil.ItemCallback<Venue>() {
    override fun areItemsTheSame(oldItem: Venue, newItem: Venue): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Venue, newItem: Venue): Boolean {
        return areContentsTheSame(oldItem, newItem)
    }
}
