package dev.dslam.merekeapp.models

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access")
    val token: String
)
