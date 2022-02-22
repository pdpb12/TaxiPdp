package me.ruyeo.taxiui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.ruyeo.taxiui.R
import me.ruyeo.taxiui.model.Banner

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private val sliderItems: ArrayList<Banner> = ArrayList()

    inner class SliderViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {
            val banner = sliderItems[adapterPosition]
            var title = view.findViewById<TextView>(R.id.title)
            var image = view.findViewById<ImageView>(R.id.image)

            title.text = banner.title
            Picasso.get().load(banner.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = sliderItems.size

    fun submitData(list: List<Banner>){
        sliderItems.addAll(list)
        notifyDataSetChanged()
    }
}
