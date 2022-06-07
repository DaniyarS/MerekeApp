package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.presentation.adapters.composeAdapter.DelegateAdapterItem
import dev.dslam.merekeapp.models.Category

data class CategoryItem(
    val category: Category
) : DelegateAdapterItem {
    override fun id(): Any = category.id.toString() + category.name

    override fun content(): Any = category
}
