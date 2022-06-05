package dev.dslam.merekeapp.models.adaptermodels

import dev.dslam.merekeapp.models.Person
import dev.dslam.merekeapp.presentation.adapters.composeAdapter.DelegateAdapterItem

data class SingerItem(
    val personList: List<Person>
) : DelegateAdapterItem {
    override fun id(): Any = personList

    override fun content(): Any = personList
}
