package com.dafa.challengesynrgytahap2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dafa.challengesynrgytahap2.databinding.FragmentOneBinding
import com.google.android.material.button.MaterialButton

class FragmentOne : Fragment() {

    private var binding: FragmentOneBinding? = null

    companion object {
        const val EXTRA_NAME = "name"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonToPageTwo?.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString(EXTRA_NAME, "Binarian Kedua")
            view.findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, bundle)
        }
    }
}