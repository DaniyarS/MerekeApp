package dev.dslam.merekeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.databinding.CategoryListItemBinding
import dev.dslam.merekeapp.interfaces.Payloadable
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.models.adaptermodels.CategoryItem
import dev.dslam.merekeapp.utils.composeAdapter.DelegateAdapter

class CategoryDelegateAdapter(
    private val viewAllClickListener: (Category) -> Unit
) :
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
        viewHolder: CategoryDelegateAdapter.CategoryItemViewHolder,
        payloads: List<Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class CategoryItemViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            binding.categoryName.text = item.category.name
            binding.viewAllText.setOnClickListener {
                viewAllClickListener(item.category)
            }
        }
    }
}