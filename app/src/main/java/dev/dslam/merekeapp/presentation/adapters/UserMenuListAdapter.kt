package dev.dslam.merekeapp.presentation.adapters

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.databinding.ProfileListItemBinding
import dev.dslam.merekeapp.models.UserMenu
import dev.dslam.merekeapp.presentation.adapters.diffUtils.UserMenuDiffUtilCallback


class UserMenuListAdapter : ListAdapter<UserMenu, UserMenuListAdapter.UserMenuViewHolder>(
    UserMenuDiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMenuViewHolder =
        UserMenuViewHolder(
            ProfileListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: UserMenuViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class UserMenuViewHolder(private val binding: ProfileListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        private val displayMetrics = DisplayMetrics()

        fun bind(userMenu: UserMenu) = with(binding) {
//            val context = root.context as Activity
//            context.windowManager.defaultDisplay.getMetrics(displayMetrics)
//
//            root.layoutParams.width = displayMetrics.widthPixels / 2

            userMenuItemButton.setImageResource(userMenu.iconId)
            userMenuItemName.text = binding.root.context.getString(userMenu.userMenuItemName)

            root.setOnClickListener {

            }
        }
    }
}
