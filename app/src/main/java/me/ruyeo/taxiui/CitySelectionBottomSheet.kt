package me.ruyeo.taxiui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import me.ruyeo.taxiui.adapter.CitySelectionAdapter
import me.ruyeo.taxiui.model.Region

class CitySelectionBottomSheet(val type: Int) : BottomSheetDialogFragment() {
    private val adapter by lazy { CitySelectionAdapter() }

    companion object {
        const val ACTION_FROM = 0
        const val ACTION_TO = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context)
            .inflate(R.layout.city_selection_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ssss2","ssss2")
        var txtType = view.findViewById<TextView>(R.id.txt_type)
        val rvRegion = view.findViewById<RecyclerView>(R.id.recycler_view)


        var list = ArrayList<Region>()
        list.add(Region("xorazm"))
        list.add(Region("Buxoro"))
        list.add(Region("Toshkent"))
        list.add(Region("Somewhere"))
        adapter.submitData(list)

        txtType.text = if (type == ACTION_FROM) "Qayerdan?" else "Qayerga?"

        val layoutmanager = LinearLayoutManager(requireContext())
        rvRegion.layoutManager = layoutmanager
        rvRegion.adapter = adapter
        adapter.itemclick = {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        }

    }


}