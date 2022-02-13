package com.slim.garland.ui.connection.method

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.slim.garland.R
import com.slim.garland.databinding.FragmentConnectionMethodBinding

class ConnectionMethodBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentConnectionMethodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_connection_method, container, false)

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
            btnSearchDeviceInNetwork.setOnClickListener {
                findNavController().navigate(R.id.action_connectionMethodFragment_to_searchDeviceInNetworkFragment)
            }
            btnConnectDeviceToNetwork.setOnClickListener {
                findNavController().navigate(R.id.action_connectionMethodFragment_to_bluetoothScannerFragment)
            }
            btnHotspot.setOnClickListener {
                findNavController().navigate(R.id.action_connectionMethodFragment_to_hotspotConnectionFragment)
            }
            btnClose.setOnClickListener {
                dismiss()
            }
        }
    }

}