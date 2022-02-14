package com.slim.garland.ui.device_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.slim.garland.R
import com.slim.garland.databinding.FragmentDeviceListBinding
import com.slim.garland.ui.RootActivity
import com.slim.garland.utils.ResUtils

class DeviceListFragment : Fragment(R.layout.fragment_device_list) {

    private val viewModel: DeviceListViewModel by viewModels { DeviceListViewModelFactory() }

    private var _binding: FragmentDeviceListBinding? = null
    private val binding get() = _binding!!

    private val deviceListAdapter = DeviceListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        setListeners()
        setObservables()

        val activityToolbar = (requireActivity() as RootActivity).toolbar
        activityToolbar.setupWithNavController(findNavController())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView(view: View) {
        _binding = FragmentDeviceListBinding.bind(view)

        binding.recyclerView.apply {
            adapter = deviceListAdapter
            addItemDecoration(
                MaterialDividerItemDecoration(requireContext(), RecyclerView.VERTICAL).also {
                    it.dividerInsetStart = ResUtils.dpToPixel(32).toInt()
                    it.dividerInsetEnd = ResUtils.dpToPixel(32).toInt()
                    it.isLastItemDecorated = false
                })
        }
    }

    private fun setObservables() {
        viewModel.apply {
            deviceList.observe(viewLifecycleOwner) {
                deviceListAdapter.setItems(it)
            }
            scannerWarning.observe(viewLifecycleOwner) {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, null)
                    .show()
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            extendedFab.setOnClickListener {
                findNavController().navigate(R.id.action_deviceListFragment_to_nav_connection)
            }
            deviceListAdapter.setOnItemClickListener {
                findNavController().navigate(R.id.action_deviceListFragment_to_deviceFragment)
            }
        }
    }

}