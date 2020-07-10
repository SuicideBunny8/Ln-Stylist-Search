package com.example.lnstylistsearch

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Filters : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.filters, container, false)
    }

    // multiple choice menu tutorial (java) https://www.youtube.com/watch?v=wfADRuyul04

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_filters_back).setOnClickListener {
            findNavController().navigate(R.id.filters_back)
        }

        view.findViewById<Button>(R.id.btn_filters_execute).setOnClickListener {
            //Perform new search here
            findNavController().navigate(R.id.filters_execute)
        }
    }
}