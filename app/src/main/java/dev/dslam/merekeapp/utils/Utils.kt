package dev.dslam.merekeapp.utils

import android.content.Context
import dev.dslam.merekeapp.utils.Constants.AUTH
import dev.dslam.merekeapp.utils.Constants.USER_TOKEN

object Utils {

    fun isAuthorized(context: Context): Boolean {
        val preferences = context.getSharedPreferences(AUTH, Context.MODE_PRIVATE)
        return preferences.getString(USER_TOKEN, null) != null
    }
}