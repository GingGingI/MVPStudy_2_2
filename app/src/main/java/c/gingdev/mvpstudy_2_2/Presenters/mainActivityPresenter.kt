package c.gingdev.mvpstudy_2_2.Presenters

import android.content.Context
import android.view.View
import c.gingdev.mvpstudy_2_2.Interfaces.mainActivityContract
import c.gingdev.mvpstudy_2_2.Models.imageData

class mainActivityPresenter: mainActivityContract.presenter {

	override lateinit var view: mainActivityContract.view
	override lateinit var imageData: imageData

	override fun loadItems(context: Context, isClear: Boolean) {
//		imageView에서 Samplelist 10개가량 가져옮.
		imageData.getSampleList(context, 10).let {
			view.update(it, isClear)
			view.notifyAdapter()
		}
	}
}