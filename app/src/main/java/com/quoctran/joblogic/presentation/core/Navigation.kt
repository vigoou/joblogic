package com.quoctran.joblogic.presentation.core

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

object Navigation {

    @SuppressLint("StaticFieldLeak")
    private lateinit var navHostFragment: NavHostFragment

    @SuppressLint("StaticFieldLeak")
    private lateinit var navController: NavController

    fun setNavigationHostFragment(navHostFragment: NavHostFragment) {
        this.navHostFragment = navHostFragment
        this.navController = this.navHostFragment.navController
    }

    fun navigationTo(actionId: Int) {
        this.navController.navigate(actionId)
    }

    fun navigationTo(actionId: Int, args: Bundle) {
        this.navController.navigate(actionId, args)
    }
}