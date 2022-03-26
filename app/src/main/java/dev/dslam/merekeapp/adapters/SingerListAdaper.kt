package dev.dslam.merekeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.adapters.diffUtils.SingerDiffUtilCallback
import dev.dslam.merekeapp.databinding.PersonListItemBinding
import dev.dslam.merekeapp.models.Singer

class SingerListAdapter(
    private val viewClickListener: (Singer) -> Unit
) : ListAdapter<Singer, SingerListAdapter.PersonViewHolder>(SingerDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(
            PersonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) = holder.bind(getItem(position))

    inner class PersonViewHolder(private val binding: PersonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(singer: Singer) {
            binding.productNameTextView.text = singer.name
            //binding.ratingTextView.text = singer.rating.toString()
            binding.productAddressTextview.text = singer.description

            binding.root.setOnClickListener {
                viewClickListener(singer)
            }

            Glide
                .with(binding.root)
                .load(singer.image)
                .centerCrop()
                .into(binding.productImageView)
        }
    }
}
