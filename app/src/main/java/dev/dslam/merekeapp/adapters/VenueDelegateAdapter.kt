package dev.dslam.merekeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.PersonListItemBinding
import dev.dslam.merekeapp.interfaces.Payloadable
import dev.dslam.merekeapp.models.Venue
import dev.dslam.merekeapp.models.adaptermodels.VenueItem
import dev.dslam.merekeapp.utils.composeAdapter.DelegateAdapter

class VenueDelegateAdapter(
    private val viewClickListener: (Venue) -> Unit
) : DelegateAdapter<VenueItem, VenueDelegateAdapter.VenueItemViewHolder>(VenueItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        VenueItemViewHolder(
            PersonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun bindViewHolder(
        model: VenueItem,
        viewHolder: VenueDelegateAdapter.VenueItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class VenueItemViewHolder(private val binding: PersonListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VenueItem) {
            binding.productNameTextView.text = item.venue.name
            binding.ratingTextView.text = item.venue.rating.toString()
            binding.productAddressTextview.text = item.venue.description

            binding.root.setOnClickListener {
                viewClickListener(item.venue)
            }

            Glide
                .with(binding.root)
                .load(item.venue.image)
                .centerCrop()
                .into(binding.productImageView)
        }
    }
}
