package dev.dslam.merekeapp.adapters.delegateAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.adapters.SingerListAdapter
import dev.dslam.merekeapp.databinding.VerticalListItemBinding
import dev.dslam.merekeapp.adapters.composeAdapter.Payloadable
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.adaptermodels.SingerItem
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapter

class SingerDelegateAdapter(
    private val singerClickListener: (Singer) -> Unit
) : DelegateAdapter<SingerItem, SingerDelegateAdapter.SingerItemViewHolder>(SingerItem::class.java) {

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

        private val singerListAdapter by lazy {
            SingerListAdapter(
                viewClickListener = {
                    singerClickListener(it)
                }
            )
        }

        fun bind(item: SingerItem) {
            with(binding) {
                productList.layoutManager = LinearLayoutManager(this.root.context, LinearLayoutManager.HORIZONTAL, false)
                productList.addItemDecoration(
                    EqualSpacingItemDecoration(8, EqualSpacingItemDecoration.HORIZONTAL)
                )
                productList.adapter = singerListAdapter
                singerListAdapter.submitList(item.singers)
            }
        }
    }
}