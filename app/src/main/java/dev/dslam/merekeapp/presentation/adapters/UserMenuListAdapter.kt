package dev.dslam.merekeapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.databinding.ProfileListItemBinding
import dev.dslam.merekeapp.models.UserMenu
import dev.dslam.merekeapp.presentation.adapters.diffUtils.UserMenuDiffUtilCallback

class UserMenuListAdapter : ListAdapter<UserMenu, UserMenuListAdapter.UserMenuViewHolder>(
    UserMenuDiffUtilCallback()
) {

    val menuClick: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMenuViewHolder =
        UserMenuViewHolder(
            ProfileListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: UserMenuViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class UserMenuViewHolder(private val binding: ProfileListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userMenu: UserMenu) = with(binding) {

            userMenuItemButton.setImageResource(userMenu.iconId)
            userMenuItemName.text = binding.root.context.getString(userMenu.userMenuItemName)

            root.setOnClickListener {
                menuClick?.invoke()
            }
        }
    }
}
