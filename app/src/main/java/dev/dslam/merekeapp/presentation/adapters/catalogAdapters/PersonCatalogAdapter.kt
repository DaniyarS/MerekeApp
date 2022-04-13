package dev.dslam.merekeapp.presentation.adapters.catalogAdapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.models.Person
import dev.dslam.merekeapp.presentation.adapters.diffUtils.PersonDiffUtilCallback

class PersonCatalogAdapter : ListAdapter<Person, PersonCatalogAdapter.ViewHolder>(
    PersonDiffUtilCallback()
) {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}