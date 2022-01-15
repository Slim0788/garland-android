package com.slim.garland.ui.connection.method

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.slim.garland.R
import com.slim.garland.databinding.FragmentConnectionMethodBinding

class ConnectionMethodFragment : Fragment(R.layout.fragment_connection_method) {

    private var _binding: FragmentConnectionMethodBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        setListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView(view: View) {
        _binding = FragmentConnectionMethodBinding.bind(view)
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnWebSearch.setOnClickListener {

            }
            btnConnectDeviceToNetwork.setOnClickListener {
                findNavController().navigate(R.id.action_connectionMethodFragment_to_deviceScannerFragment)
            }
            btnConnectToDevice.setOnClickListener {

            }
        }
    }

}