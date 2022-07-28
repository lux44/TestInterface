package com.lux.zena.testinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lux.zena.testinterface.R
import com.lux.zena.testinterface.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    val binding:FragmentFirstBinding by lazy { FragmentFirstBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Horizontal ProgressBar
        binding.progressBar.visibility = View.VISIBLE

        // SeekBar
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(context, "Progress is ${p0?.progress}%", Toast.LENGTH_SHORT).show()
            }

        })

        // AutoComplete TextView
        val autoWords = resources.getStringArray(R.array.auto_text_array)
        val adapter = context?.let { ArrayAdapter(it, R.layout.auto_complete_tv_sample, autoWords) }
        binding.autoTv.setAdapter(adapter)
    }


}