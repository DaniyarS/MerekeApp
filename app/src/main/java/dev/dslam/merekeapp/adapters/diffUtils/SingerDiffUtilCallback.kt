package dev.dslam.merekeapp.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.Singer

class SingerDiffUtilCallback : DiffUtil.ItemCallback<Singer>() {
    override fun areItemsTheSame(oldItem: Singer, newItem: Singer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Singer, newItem: Singer): Boolean {
        return areContentsTheSame(oldItem, newItem)
    }
}