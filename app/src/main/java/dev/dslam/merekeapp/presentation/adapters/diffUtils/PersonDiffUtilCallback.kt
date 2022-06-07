package dev.dslam.merekeapp.presentation.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.Person

class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return true //oldItem.id.toString() + oldItem.description == newItem.id.toString() + newItem.description
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return true //areContentsTheSame(oldItem, newItem)
    }
}