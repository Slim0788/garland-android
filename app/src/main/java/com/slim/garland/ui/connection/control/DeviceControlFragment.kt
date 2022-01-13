package com.slim.garland.ui.connection.control

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.slim.garland.R
import com.slim.garland.databinding.FragmentDeviceControlBinding
import com.slim.garland.ui.connection.password.WiFiPasswordFragment

class DeviceControlFragment : Fragment(R.layout.fragment_device_control) {

    private val viewModel: DeviceControlViewModel by viewModels {
        DeviceControlViewModelFactory(requireArguments().getString(ARG_DEVICE_ADDRESS) ?: "")
    }

    private var _binding: FragmentDeviceControlBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_DEVICE_ADDRESS = "arg_device_address"
        const val REQUEST_KEY_CREDENTIALS = "request_key_password"
        private const val ARG_REQUEST_SSID = "arg_request_ssid"
        private const val ARG_REQUEST_PASSWORD = "arg_request_password"

        fun newInstance(deviceAddress: String) = DeviceControlFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_DEVICE_ADDRESS, deviceAddress)
            }
        }

        fun getBundleForResult(ssid: String, password: String) = Bundle().apply {
            putString(ARG_REQUEST_SSID, ssid)
            putString(ARG_REQUEST_PASSWORD, password)
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
    }

    private fun setObservables() {
        viewModel.apply {
            scannerWarning.observe(viewLifecycleOwner) {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok) {}
                    .show()
            }
            workedTime.observe(viewLifecycleOwner) {
                binding.textWorkedTime.text = it
            }
            address.observe(viewLifecycleOwner) {
                binding.textAddress.text = it
            }
            connectingProgress.observe(viewLifecycleOwner) {
                if (it) binding.progress.show() else binding.progress.hide()
            }
            messageFromDevice.observe(viewLifecycleOwner) {
                binding.textReceivedMessage.text = it
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }
            btnConnect.setOnClickListener {
                viewModel.connect()
            }
            btnDisconnect.setOnClickListener {
                viewModel.disconnect()
            }
            btnSendMessage.setOnClickListener {
                viewModel.sendCredentialsRequest()
            }
            btnWifiPassword.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, WiFiPasswordFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }

            setFragmentResultListener(REQUEST_KEY_CREDENTIALS) { _, bundle ->
                viewModel.apply {
                    ssid = bundle.getString(ARG_REQUEST_SSID, "")
                    password = bundle.getString(ARG_REQUEST_PASSWORD, "")
                }
            }

        }
    }

}