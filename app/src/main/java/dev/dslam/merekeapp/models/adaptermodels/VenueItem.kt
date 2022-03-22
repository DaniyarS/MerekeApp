package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.interfaces.DelegateAdapterItem
import dev.dslam.merekeapp.interfaces.Payloadable
import dev.dslam.merekeapp.models.Venue

data class VenueItem(
    val venue: Venue
) : DelegateAdapterItem {
    override fun id(): Any = venue.id

    override fun content(): Any = VenueInfoContent(venue.name, venue.description)

    inner class VenueInfoContent(val name: String, val description: String) {
        override fun equals(other: Any?): Boolean {
            if (other is VenueInfoContent) {
                return name == other.name && description == other.description
            }

            return false
        }

        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + description.hashCode()

            return result
        }
    }

    sealed class ChangePayload: Payloadable {
        data class ratingChanged(val rating: Float): ChangePayload()
    }
}
