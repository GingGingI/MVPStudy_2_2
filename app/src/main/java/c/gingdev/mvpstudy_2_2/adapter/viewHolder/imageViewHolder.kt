package c.gingdev.mvpstudy_2_2.adapter.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.mvpstudy_2_2.R

class imageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

	val imageView by lazy { itemView.findViewById(R.id.imageView) as ImageView }
	val text by lazy { itemView.findViewById(R.id.Text) as TextView }
}