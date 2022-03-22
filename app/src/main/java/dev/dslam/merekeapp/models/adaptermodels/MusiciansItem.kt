package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.interfaces.DelegateAdapterItem
import dev.dslam.merekeapp.interfaces.Payloadable

data class MusiciansItem(
    val id: Int,
    val name: String,
    val instruments: List<String>,
    val description: String,
    val rating: Float,
    val image: String
) : DelegateAdapterItem {
    override fun id(): Any = id

    override fun content(): Any = MusiciansInfoContent(name, description)

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
