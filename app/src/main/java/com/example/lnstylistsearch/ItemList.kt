package com.example.lnstylistsearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ItemList : Fragment(), AdapterView.OnItemSelectedListener {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_list_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val catSpinner: Spinner = requireView().findViewById(R.id.Category_Spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.category_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            catSpinner.adapter = adapter
        }

        catSpinner.onItemSelectedListener = this

        view.findViewById<Button>(R.id.toSettings).setOnClickListener {
            findNavController().navigate(R.id.main_to_settings)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        //TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        //TODO("Not yet implemented")
    }
}