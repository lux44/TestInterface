package com.lux.zena.testinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lux.zena.testinterface.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    val binding:FragmentSecondBinding by lazy { FragmentSecondBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}