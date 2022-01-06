package com.slim.garland.ui.connection.control

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.slim.garland.R
import com.slim.garland.databinding.FragmentDeviceControlBinding

class DeviceControlFragment : Fragment(R.layout.fragment_device_control) {

    private val viewModel: DeviceControlViewModel by viewModels {
        DeviceControlViewModelFactory(requireActivity().application)
    }

    private var _binding: FragmentDeviceControlBinding? = null
    private val binding get() = _binding!!

    private val deviceAddress: String? by lazy { requireArguments().getString(ARG_DEVICE_ADDRESS) }

    companion object {
        private const val ARG_DEVICE_ADDRESS = "arg_device_address"

        fun newInstance(deviceAddress: String) = DeviceControlFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_DEVICE_ADDRESS, deviceAddress)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        setListeners()
        setObservables()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView(view: View) {
        _binding = FragmentDeviceControlBinding.bind(view)

        binding.textAddress.text = deviceAddress
    }

    private fun setObservables() {
        viewModel.apply {

        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }

        }
    }

}