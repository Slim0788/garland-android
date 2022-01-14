package com.slim.garland.ui.connection.method

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.slim.garland.R
import com.slim.garland.databinding.FragmentConnectionMethodBinding
import com.slim.garland.ui.connection.scanner.DeviceScannerFragment

class ConnectionMethodFragment : Fragment(R.layout.fragment_connection_method) {

    private var _binding: FragmentConnectionMethodBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ConnectionMethodFragment()
    }

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
                parentFragmentManager.popBackStack()
            }
            btnWebSearch.setOnClickListener {

            }
            btnConnectDeviceToNetwork.setOnClickListener {
                redirectTo(DeviceScannerFragment.newInstance())
            }
            btnConnectToDevice.setOnClickListener {

            }
        }
    }

    private fun redirectTo(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

}