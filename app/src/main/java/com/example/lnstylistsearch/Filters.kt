package com.example.lnstylistsearch

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Filters : Fragment() {
    // Textviews
    private lateinit var txtViewClr1: TextView
    private lateinit var txtViewClr2: TextView

    // string arrays for options
    private lateinit var clr1List: Array<String>
    private lateinit var clr2List: Array<String>

    // boolean arrays of selections
    private lateinit var clr1SelList: BooleanArray
    private lateinit var clr2SelList: BooleanArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.filters, container, false)
    }

    // multiple choice menu tutorial (java) https://www.youtube.com/watch?v=wfADRuyul04

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        txtViewClr1 = requireView().findViewById<TextView>(R.id.txt_clr1_sel)
        txtViewClr2 = requireView().findViewById<TextView>(R.id.txt_clr2_sel)

        clr1List = resources.getStringArray(R.array.color_1_ops)
        clr2List = resources.getStringArray(R.array.color_2_ops)

        clr1SelList = BooleanArray(clr1List.size)
        clr2SelList = BooleanArray(clr2List.size)

        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_filters_back).setOnClickListener {
            findNavController().navigate(R.id.filters_back)
        }

        view.findViewById<Button>(R.id.btn_filters_execute).setOnClickListener {
            //TODO: implement database search to occur here
            findNavController().navigate(R.id.filters_execute)
        }

        // Clear all filters
        view.findViewById<Button>(R.id.btn_clr_filters).setOnClickListener {
            //TODO: implement filter clear here
        }

        // make color 1 selections
        view.findViewById<Button>(R.id.btn_clr1_sel).setOnClickListener {
            // create a dialog box for filter selection
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Color 1 Options")
            builder.setMultiChoiceItems(clr1List, clr1SelList, { dialog, i, b ->
                    clr1SelList[i] = b
                })

            builder.setPositiveButton("OK") { _, _ ->
                var nFirst = false
                // display selections in the text box
                for (i in clr1List.indices) {
                    val checked = clr1SelList[i]
                    if (checked) {
                        if (nFirst) {
                            txtViewClr1.text = "${txtViewClr1.text}, ${clr1List[i]}"
                        } else {
                            txtViewClr1.text = clr1List[i]
                            nFirst = true
                        }
                    }
                }
                if (!nFirst) {
                    // if all selections manually deselected clear the text box
                    txtViewClr1.text = ""
                }
            }

            builder.setNegativeButton("Clear All") { _, _ ->
                for (i in clr1SelList.indices) {
                    clr1SelList[i] = false
                }
                txtViewClr1.text = ""
            }

            val dialog = builder.create()
            dialog.show()
        }

        // make color 2 selections
        view.findViewById<Button>(R.id.btn_clr2_sel).setOnClickListener {
            // create a dialog box for filter selection
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Color 2 Options")
            builder.setMultiChoiceItems(clr2List, clr2SelList, { dialog, i, b ->
                clr2SelList[i] = b
            })

            builder.setPositiveButton("OK") { _, _ ->
                var nFirst = false
                // display selections in the text box
                for (i in clr2List.indices) {
                    val checked = clr2SelList[i]
                    if (checked) {
                        if (nFirst) {
                            txtViewClr2.text = "${txtViewClr2.text}, ${clr2List[i]}"
                        } else {
                            txtViewClr2.text = clr2List[i]
                            nFirst = true
                        }
                    }
                }
                if (!nFirst) {
                    // if all selections manually deselected clear the text box
                    txtViewClr2.text = ""
                }
            }

            builder.setNegativeButton("Clear All") { _, _ ->
                for (i in clr2SelList.indices) {
                    clr2SelList[i] = false
                }
                txtViewClr2.text = ""
            }

            val dialog = builder.create()
            dialog.show()
        }

        // make style 1 selections
        view.findViewById<Button>(R.id.btn_sty1_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make style 2 selections
        view.findViewById<Button>(R.id.btn_sty2_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make posed selections
        view.findViewById<Button>(R.id.btn_posed_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make special attribute 1 selections
        view.findViewById<Button>(R.id.btn_spa1_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make special attribute 2 selections
        view.findViewById<Button>(R.id.btn_spa2_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make rarity selections
        view.findViewById<Button>(R.id.btn_rar_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }

        // make gallery section selections
        view.findViewById<Button>(R.id.btn_gal_sel).setOnClickListener {
            //TODO: repeat color 1 selection implementation here
        }
    }
}