package c.gingdev.mvpstudy_2_2.Models

import android.content.Context

object imageData {
	fun getSampleList(context: Context, size: Int): ArrayList<imageItem> {
		val list = ArrayList<imageItem>()
		for (index in 0..size) {
			val name = String.format("sample_%02d", (Math.random() * 15).toInt())
			val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
			list.add(imageItem(resource, name))
		}
		return list
	}
}