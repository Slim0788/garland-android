package com.slim.garland.ui.device.effects

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.slim.garland.R
import com.slim.garland.databinding.FragmentDeviceEffectsBinding

class DeviceEffectsFragment : Fragment(R.layout.fragment_device_effects) {

    private val viewModel: DeviceEffectsViewModel by viewModels()

    private var _binding: FragmentDeviceEffectsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        initToolbarMenu()
        setListeners()
        setObservables()
    }

    private fun initView(view: View) {
        _binding = FragmentDeviceEffectsBinding.bind(view)
    }

    private fun initToolbarMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_test, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menu_test -> {
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setListeners() {
        binding.apply {

        }
    }

    private fun setObservables() {
        viewModel.apply {

        }
    }

}