package dev.dslam.merekeapp.adapters.delegateAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.adapters.VenueListAdapter
import dev.dslam.merekeapp.databinding.VerticalListItemBinding
import dev.dslam.merekeapp.adapters.composeAdapter.Payloadable
import dev.dslam.merekeapp.models.Venue
import dev.dslam.merekeapp.models.adaptermodels.VenueItem
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapter

class VenueDelegateAdapter(
    private val venueClickListener: (Venue) -> Unit
) : DelegateAdapter<VenueItem, VenueDelegateAdapter.VenueItemViewHolder>(VenueItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        VenueItemViewHolder(
            VerticalListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun bindViewHolder(
        model: VenueItem,
        viewHolder: VenueItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class VenueItemViewHolder(private val binding: VerticalListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val venueListAdapter by lazy {
            VenueListAdapter(
                viewClickListener = {
                    venueClickListener(it)
                }
            )
        }

        fun bind(item: VenueItem) {
            with(binding) {
                productList.apply {
                    layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
                    addItemDecoration(
                        EqualSpacingItemDecoration(8, EqualSpacingItemDecoration.HORIZONTAL)
                    )
                    adapter = venueListAdapter
                }
                venueListAdapter.submitList(item.venues)
            }
        }
    }
}
