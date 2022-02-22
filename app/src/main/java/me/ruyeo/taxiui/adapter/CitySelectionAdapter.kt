package me.ruyeo.taxiui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.ruyeo.taxiui.R
import me.ruyeo.taxiui.model.Region

class CitySelectionAdapter : RecyclerView.Adapter<CitySelectionAdapter.ViewHolder>() {
    private val regionItems: ArrayList<Region> = ArrayList()
    lateinit var itemclick: ((Region) -> Unit)

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {
            val region = regionItems[adapterPosition]
            var title = view.findViewById<TextView>(R.id.name)
            var root = view.findViewById<LinearLayout>(R.id.ll_root)

            root.setOnClickListener {
                itemclick.invoke(region)
            }

            title.text = region.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_selection, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = regionItems.size

    fun submitData(list: List<Region>){
        regionItems.addAll(list)
        notifyDataSetChanged()
    }
}
