package dev.dslam.merekeapp.presentation.adapters.delegateAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.presentation.adapters.PersonListAdapter
import dev.dslam.merekeapp.databinding.VerticalListItemBinding
import dev.dslam.merekeapp.presentation.adapters.composeAdapter.Payloadable
import dev.dslam.merekeapp.models.adaptermodels.SingerItem
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.presentation.adapters.composeAdapter.DelegateAdapter
import dev.dslam.merekeapp.utils.dp

class PersonDelegateAdapter : DelegateAdapter<SingerItem, PersonDelegateAdapter.SingerItemViewHolder>(SingerItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        SingerItemViewHolder(
            VerticalListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: SingerItem,
        viewHolder: SingerItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class SingerItemViewHolder(private val binding: VerticalListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val singerListAdapter = PersonListAdapter()

        fun bind(item: SingerItem) {
            with(binding) {
                productList.layoutManager = LinearLayoutManager(this.root.context, LinearLayoutManager.HORIZONTAL, false)
                productList.addItemDecoration(
                    EqualSpacingItemDecoration(16.dp, EqualSpacingItemDecoration.HORIZONTAL)
                )
                productList.adapter = singerListAdapter
                singerListAdapter.submitList(item.personList)
            }
        }
    }
}
