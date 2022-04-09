package dev.dslam.merekeapp.presentation.adapters.composeAdapter

interface DelegateAdapterItem {

    fun id(): Any

    fun content(): Any

    fun payload(other: Any): Payloadable = Payloadable.None

}
