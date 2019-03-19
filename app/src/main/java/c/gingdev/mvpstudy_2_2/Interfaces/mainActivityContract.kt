package c.gingdev.mvpstudy_2_2.Interfaces

import android.content.Context
import c.gingdev.mvpstudy_2_2.Models.imageData
import c.gingdev.mvpstudy_2_2.Models.imageItem

interface mainActivityContract {
	interface view {
		fun update(items: ArrayList<imageItem>, isClear: Boolean)
		fun notifyAdapter()
	}

	interface presenter {
		var view: view
		var imageData: imageData

		fun loadItems(context: Context, isClear: Boolean)
	}
}