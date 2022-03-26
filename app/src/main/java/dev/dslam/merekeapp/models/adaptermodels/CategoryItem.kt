package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapterItem
import dev.dslam.merekeapp.models.Category

data class CategoryItem(
    val category: Category
) : DelegateAdapterItem {
    override fun id(): Any = category.id

    override fun content(): Any = category.name
}
