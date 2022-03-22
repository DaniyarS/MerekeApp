package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.interfaces.DelegateAdapterItem
import dev.dslam.merekeapp.interfaces.Payloadable
import dev.dslam.merekeapp.models.Singer

data class SingerItem(
    val singer: Singer
) : DelegateAdapterItem {
    override fun id(): Any = singer.id

    override fun content(): Any = MusiciansInfoContent(singer.name, singer.description)

    inner class MusiciansInfoContent(private val name: String, private val description: String) {
        override fun equals(other: Any?): Boolean {
            if (other is MusiciansInfoContent) {
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
