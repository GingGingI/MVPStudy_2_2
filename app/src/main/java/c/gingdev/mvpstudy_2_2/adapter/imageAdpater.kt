package c.gingdev.mvpstudy_2_2.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.mvpstudy_2_2.Models.imageItem
import c.gingdev.mvpstudy_2_2.R
import c.gingdev.mvpstudy_2_2.adapter.viewHolder.imageViewHolder
import java.lang.ref.WeakReference

class imageAdapter(val context: Context): RecyclerView.Adapter<imageViewHolder>() {

	var imageList: ArrayList<imageItem>? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
			= imageViewHolder(LayoutInflater.from(context).inflate(R.layout.image_view, parent, false))

	override fun getItemCount() = imageList?.size ?: 0

	override fun onBindViewHolder(holder: imageViewHolder, position: Int) {
		val item = imageList?.get(position)

//		AsyncTask로 ImageView를 보내 이미지를 백그라운드상에서 처리하도록 핢.
		ImageAsync(holder.imageView).execute(item?.resource)
		holder.text.text = item?.title

		holder.itemView.setOnClickListener {
			Toast.makeText(context, "Show ${item?.title}", Toast.LENGTH_SHORT).show()
		}
	}

	inner class ImageAsync(imageView: ImageView?) : AsyncTask<Int, Void, Bitmap>() {
		val imageViewRef: WeakReference<ImageView?> = WeakReference(imageView)

		override fun onPreExecute() {
			super.onPreExecute()
			imageViewRef.get()?.setImageResource(0)
		}

		override fun doInBackground(vararg params: Int?): Bitmap {
			val options = BitmapFactory.Options()
			options.inSampleSize = 2
			return BitmapFactory.decodeResource(context.resources, params[0] as Int, options)
		}

		override fun onPostExecute(result: Bitmap?) {
			super.onPostExecute(result)
			result?.let { imageViewRef.get()?.setImageBitmap(result) }
		}
	}
}