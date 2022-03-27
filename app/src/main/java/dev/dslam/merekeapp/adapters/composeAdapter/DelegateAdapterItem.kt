package dev.dslam.merekeapp.adapters.composeAdapter

import dev.dslam.merekeapp.adapters.composeAdapter.Payloadable

interface DelegateAdapterItem {

    fun id(): Any

    fun content(): Any

    fun payload(other: Any): Payloadable = Payloadable.None

}
