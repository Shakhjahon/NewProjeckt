package com.example.newprojeckt.data.prefences.face_data

import android.content.Context

private const val SHARED_PREFENCES_KEY = "SHARED_PREFENCES_KEY"
private const val USER_SIGN_SHARED_KEY = "USER_SIGN_SHARED_KEY"

class UserEnteredSharedpref(
    private val context: Context,
) {

    private val sharedPrefences = context.getSharedPreferences(
        SHARED_PREFENCES_KEY, Context.MODE_PRIVATE
    )

    fun getIsUserFirstSign(): Boolean {
        return sharedPrefences.getBoolean(USER_SIGN_SHARED_KEY, false)
    }

    fun setUserFirstSign(userFirstSign: Boolean) {
        sharedPrefences.edit().putBoolean(USER_SIGN_SHARED_KEY, userFirstSign).apply()
    }
}