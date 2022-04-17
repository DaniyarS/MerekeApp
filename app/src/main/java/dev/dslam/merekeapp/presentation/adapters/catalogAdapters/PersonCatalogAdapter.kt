package dev.dslam.merekeapp.presentation.adapters.catalogAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.PersonListItemBinding
import dev.dslam.merekeapp.models.Person
import dev.dslam.merekeapp.presentation.adapters.diffUtils.PersonDiffUtilCallback
import dev.dslam.merekeapp.presentation.fragments.mainMenu.HomeFragmentDirections

class PersonCatalogAdapter : ListAdapter<Person, PersonCatalogAdapter.ViewHolder>(
    PersonDiffUtilCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val binding: PersonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.personNameTextView.text = person.name
            // binding.ratingTextView.text = singer.rating.toString()
            binding.personDescriptionTextview.text = person.description

            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToPersonDetailsActivity(person = person)
                itemView.findNavController().navigate(action)
            }

            Glide
                .with(binding.root)
                .load(person.images[0].imageUrl)
                .centerCrop()
                .into(binding.personImageView)
        }
    }
}