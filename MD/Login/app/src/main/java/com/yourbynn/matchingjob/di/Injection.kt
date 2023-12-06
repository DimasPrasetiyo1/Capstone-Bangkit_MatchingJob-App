package com.yourbynn.matchingjob.di

import android.content.Context
import com.yourbynn.matchingjob.data.UserPreference
import com.yourbynn.matchingjob.data.UserRepository
import com.yourbynn.matchingjob.data.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}