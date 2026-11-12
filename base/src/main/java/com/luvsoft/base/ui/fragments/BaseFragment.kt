package com.luvsoft.base.ui.fragments

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    open fun loadFragment(fragment: Fragment, nav_host: Int) {
        parentFragmentManager.beginTransaction()
            .replace(nav_host, fragment)
            .addToBackStack(null)
            .commit()
    }
}
