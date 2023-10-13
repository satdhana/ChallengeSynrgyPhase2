package com.dafa.challengesynrgytahap2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class FragmentTwo : Fragment() {

    private var text2: AppCompatTextView? = null
    private var buttonToPageThree: MaterialButton? = null
    private var editName: TextInputEditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text2 = view.findViewById(R.id.text2)
        buttonToPageThree = view.findViewById(R.id.button_to_page_three)
        editName = view.findViewById(R.id.edit_name)

        val name = arguments?.getString(FragmentOne.EXTRA_NAME)

        text2?.text = "Nama kamu: $name"

        buttonToPageThree?.setOnClickListener { view ->
            if (editName?.text.isNullOrEmpty()) {
                Toast.makeText(view.context, "Kolom Nama masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                val actionToFragmentThree = FragmentTwoDirections.actionFragmentTwoToFragmentThree()
                actionToFragmentThree.name = editName?.text?.toString()
                view.findNavController().navigate(actionToFragmentThree)
            }
        }
    }
}