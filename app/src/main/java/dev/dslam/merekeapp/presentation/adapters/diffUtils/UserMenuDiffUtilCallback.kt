package dev.dslam.merekeapp.presentation.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.merekeapp.models.UserMenu

class UserMenuDiffUtilCallback : DiffUtil.ItemCallback<UserMenu>() {
    override fun areItemsTheSame(oldItem: UserMenu, newItem: UserMenu): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserMenu, newItem: UserMenu): Boolean {
        return oldItem.iconId == newItem.iconId && oldItem.userMenuItemName == newItem.userMenuItemName
    }
}
