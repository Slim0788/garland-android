package com.slim.garland.ui.connection.password

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.slim.garland.R
import com.slim.garland.databinding.FragmentWifiPasswordBinding
import com.slim.garland.ui.connection.control.DeviceControlFragment
import com.slim.garland.ui.connection.wifi.WiFiScanningFragment

class WiFiPasswordFragment : Fragment(R.layout.fragment_wifi_password) {

    private val viewModel: WiFiPasswordViewModel by viewModels {
        WiFiPasswordViewModelFactory()
    }

    private var _binding: FragmentWifiPasswordBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = WiFiPasswordFragment()
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
        _binding = FragmentWifiPasswordBinding.bind(view)
    }

    private fun setObservables() {
        viewModel.apply {
            ssidLiveData.observe(viewLifecycleOwner) {
                binding.textMessage.text = it
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }
            btnAnotherWifi.setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.container, WiFiScanningFragment.newInstance())
//                    .addToBackStack(null)
//                    .commit()
            }
            btnWifiSettings.setOnClickListener {
                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
            }
            btnSubmitPassword.setOnClickListener {
                setFragmentResult(
                    DeviceControlFragment.REQUEST_KEY_CREDENTIALS,
                    DeviceControlFragment.getBundleForResult(
                        binding.textMessage.text.toString(),
                        etPassword.text.toString()
                    )
                )
                parentFragmentManager.popBackStack()
            }
        }
    }

}