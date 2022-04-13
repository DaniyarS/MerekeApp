package dev.dslam.merekeapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.presentation.adapters.diffUtils.SingerDiffUtilCallback
import dev.dslam.merekeapp.databinding.PersonListItemBinding
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.presentation.fragments.mainMenu.HomeFragmentDirections

class SingerListAdapter : ListAdapter<Singer, SingerListAdapter.PersonViewHolder>(SingerDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(
            PersonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) = holder.bind(getItem(position))

    inner class PersonViewHolder(private val binding: PersonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(singer: Singer) {
            binding.productNameTextView.text = singer.name
            // binding.ratingTextView.text = singer.rating.toString()
            binding.productAddressTextview.text = singer.description

            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToPersonDetailsActivity(person = singer)
                itemView.findNavController().navigate(action)
            }

            Glide
                .with(binding.root)
                .load(singer.images[0].imageUrl)
                .centerCrop()
                .into(binding.productImageView)
        }
    }
}
