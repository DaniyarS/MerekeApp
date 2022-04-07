package dev.dslam.merekeapp.presentation.adapters.delegateAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.CategoryListItemBinding
import dev.dslam.merekeapp.presentation.adapters.composeAdapter.Payloadable
import dev.dslam.merekeapp.models.adaptermodels.CategoryItem
import dev.dslam.merekeapp.presentation.adapters.composeAdapter.DelegateAdapter
import dev.dslam.merekeapp.presentation.fragments.constants.Constants

class CategoryDelegateAdapter :
    DelegateAdapter<CategoryItem, CategoryDelegateAdapter.CategoryItemViewHolder>(CategoryItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        CategoryItemViewHolder(
            CategoryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun bindViewHolder(
        model: CategoryItem,
        viewHolder: CategoryItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class CategoryItemViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            binding.categoryName.text = item.category.name
            binding.viewAllText.setOnClickListener {
                val bundle = bundleOf(Constants.CATEGORY_ID to item.category.id)

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.homeFragment, inclusive = false, saveState = true)
                    .setRestoreState(true)
                    .build()

                itemView.findNavController().navigate(R.id.catalogFragment, bundle, navOptions)
            }
        }
    }
}
