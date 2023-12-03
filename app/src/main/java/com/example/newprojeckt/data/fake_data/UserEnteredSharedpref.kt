package com.example.newprojeckt.data.fake_data

import android.content.Context
import com.example.newprojeckt.data.model.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val USER_SIGN_SHARED_KEY = "USER_SIGN_SHARED_KEY"

class UserEnteredSharedpref(
    private val context: Context,
) {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getIsUserFirstSign(): Boolean {
        return sharedPreferences.getBoolean(USER_SIGN_SHARED_KEY, false)
    }

    fun setUserFirstSign(userFirstSign: Boolean) {
        sharedPreferences.edit().putBoolean(USER_SIGN_SHARED_KEY, userFirstSign).apply()
    }
}