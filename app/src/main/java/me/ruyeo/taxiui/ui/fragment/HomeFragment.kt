package me.ruyeo.taxiui.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.ruyeo.taxiui.CitySelectionBottomSheet
import me.ruyeo.taxiui.CitySelectionBottomSheet.Companion.ACTION_FROM
import me.ruyeo.taxiui.CitySelectionBottomSheet.Companion.ACTION_TO
import me.ruyeo.taxiui.R
import me.ruyeo.taxiui.adapter.SliderAdapter
import me.ruyeo.taxiui.model.Banner


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var isDrawerOpen = false
    private val adapter by lazy { SliderAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI(view)
    }

    private fun setupUI(view: View) {
        val btnMenu = view.findViewById<ImageView>(R.id.btn_menu)
        val draweLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val slider = view.findViewById<ViewPager2>(R.id.slider)
        val tvFrom = view.findViewById<TextView>(R.id.tv_from)
        val tvTo = view.findViewById<TextView>(R.id.tv_to)
        var indicator = view.findViewById<TabLayout>(R.id.tabIndicator)


        tvFrom.setOnClickListener {
            Log.d("ssss","ssss")
            tvFrom.background = resources.getDrawable(R.drawable.bg_edit_text)
           openRegionSheet(ACTION_FROM)
        }

        tvTo.setOnClickListener {
            CitySelectionBottomSheet(ACTION_TO)
        }

        setData()
        slider.adapter = adapter

        TabLayoutMediator(indicator,slider){_,_ ->}.attach()

        slider.offscreenPageLimit = 3
        slider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        btnMenu.setOnClickListener {
            draweLayout.open()
        }
    }

    private fun openRegionSheet(type: Int) {
        val dialog = CitySelectionBottomSheet(type)
        dialog.show(requireActivity().supportFragmentManager,null)
    }

    private fun setData() {
        var list = ArrayList<Banner>()
        list.add(
            Banner(
                "https://st2.depositphotos.com/3591429/5992/i/600/depositphotos_59926519-stock-photo-yellow-sedan-taxi-car.jpg",
                "Taxi"
            )
        )
        list.add(
            Banner(
                "https://thumbs.dreamstime.com/b/%D0%B6%D0%B5%D0%BB%D1%82%D0%B0%D1%8F-%D0%B8%D0%B3%D1%80%D1%83%D1%88%D0%B5%D1%87%D0%BD%D0%B0%D1%8F-%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%D0%B0-%D1%82%D0%B0%D0%BA%D1%81%D0%B8-%D0%B8%D0%B7%D0%BE%D0%BB%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D0%B0%D1%8F-%D0%BD%D0%B0-%D0%B1%D0%B5%D0%BB%D0%BE%D0%BC-%D1%84%D0%BE%D0%BD%D0%B5-165333285.jpg",
                "Taxi"
            )
        )
        list.add(
            Banner(
                "https://st2.depositphotos.com/3591429/5992/i/600/depositphotos_59926519-stock-photo-yellow-sedan-taxi-car.jpg",
                "Taxi"
            )
        )
        adapter.submitData(list)
    }
}