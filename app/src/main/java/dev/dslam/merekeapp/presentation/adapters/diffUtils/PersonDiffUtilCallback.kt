package dev.dslam.merekeapp.presentation.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.Person

class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return areContentsTheSame(oldItem, newItem)
    }
}