package dev.dslam.merekeapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.presentation.adapters.diffUtils.VenueDiffUtilCallback
import dev.dslam.merekeapp.databinding.VenueListItemBinding
import dev.dslam.merekeapp.models.Venue

class VenueListAdapter(
    private val viewClickListener: (Venue) -> Unit
) : ListAdapter<Venue, VenueListAdapter.VenueViewHolder>(VenueDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder =
        VenueViewHolder(
            VenueListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) = holder.bind(getItem(position))

    inner class VenueViewHolder(private val binding: VenueListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(venue: Venue) {
            binding.productNameTextView.text = venue.name
            // binding.ratingTextView.text = venue.rating.toString()
            binding.productAddressTextview.text = venue.description

            binding.root.setOnClickListener {
                viewClickListener(venue)
            }

            Glide
                .with(binding.root)
                .load(venue.images[0].imageUrl)
                .centerCrop()
                .into(binding.productImageView)
        }
    }
}
