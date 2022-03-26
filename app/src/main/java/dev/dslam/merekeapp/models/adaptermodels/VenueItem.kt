package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapterItem
import dev.dslam.merekeapp.models.Venue

data class VenueItem(
    val venues: List<Venue>
) : DelegateAdapterItem {
    override fun id(): Any = venues

    override fun content(): Any = venues
}
