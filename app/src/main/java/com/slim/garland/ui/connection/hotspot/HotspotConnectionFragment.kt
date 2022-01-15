package com.slim.garland.ui.connection.hotspot

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.slim.garland.R
import com.slim.garland.databinding.FragmentHotspotConnectionBinding

class HotspotConnectionFragment : Fragment(R.layout.fragment_hotspot_connection) {

    private val viewModel: HotspotConnectionViewModel by viewModels()

    private var _binding: FragmentHotspotConnectionBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentHotspotConnectionBinding.bind(view)
    }

    private fun setObservables() {
        viewModel.apply {

        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }

        }
    }

}