package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapterItem
import dev.dslam.merekeapp.models.Singer

data class SingerItem(
    val singers: List<Singer>
) : DelegateAdapterItem {
    override fun id(): Any = singers

    override fun content(): Any = singers
}
