package dev.dslam.merekeapp.presentation.adapters.catalogAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.VenueCatalogListItemBinding
import dev.dslam.merekeapp.models.Venue
import dev.dslam.merekeapp.presentation.adapters.diffUtils.VenueDiffUtilCallback
import dev.dslam.merekeapp.presentation.fragments.mainMenu.CatalogFragmentDirections

class VenueCatalogAdapter : ListAdapter<Venue, VenueCatalogAdapter.ViewHolder>(
    VenueDiffUtilCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = VenueCatalogListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val binding: VenueCatalogListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(venue: Venue) {
            binding.venueNameTextView.text = venue.name
            // binding.ratingTextView.text = singer.rating.toString()
            binding.venueAddressTextview.text = venue.address

            binding.root.setOnClickListener {
                val action = CatalogFragmentDirections.actionCatalogFragmentToVenueDetailsActivity(venue = venue)
                itemView.findNavController().navigate(action)
            }

            Glide
                .with(binding.root)
                .load(venue.images[0].imageUrl)
                .centerCrop()
                .into(binding.venueImageView)
        }
    }
}