package dev.dslam.merekeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.PersonListItemBinding
import dev.dslam.merekeapp.interfaces.Payloadable
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.adaptermodels.SingerItem
import dev.dslam.merekeapp.utils.composeAdapter.DelegateAdapter

class SingerDelegateAdapter(
    private val viewClickListener: (Singer) -> Unit
) :
    DelegateAdapter<SingerItem, SingerDelegateAdapter.SingerItemViewHolder>(SingerItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        SingerItemViewHolder(
            PersonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun bindViewHolder(
        model: SingerItem,
        viewHolder: SingerDelegateAdapter.SingerItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class SingerItemViewHolder(private val binding: PersonListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SingerItem) {
            binding.productNameTextView.text = item.singer.name
            binding.ratingTextView.text = item.singer.rating.toString()
            binding.productAddressTextview.text = item.singer.description

            binding.root.setOnClickListener {
                viewClickListener(item.singer)
            }

            Glide
                .with(binding.root)
                .load(item.singer.image)
                .centerCrop()
                .into(binding.productImageView)
        }
    }
}