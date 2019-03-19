package c.gingdev.mvpstudy_2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import c.gingdev.mvpstudy_2_2.Interfaces.mainActivityContract
import c.gingdev.mvpstudy_2_2.Models.imageItem
import c.gingdev.mvpstudy_2_2.Presenters.mainActivityPresenter
import c.gingdev.mvpstudy_2_2.adapter.imageAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), mainActivityContract.view {

	private lateinit var presenter: mainActivityPresenter

	private var imageAdapter: imageAdapter? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		presenter = mainActivityPresenter().apply {
			view = this@MainActivity
			imageData = c.gingdev.mvpstudy_2_2.Models.imageData
		}

		imageAdapter = imageAdapter(this)

		recyclerView.let {
			it.adapter = imageAdapter
			it.layoutManager = LinearLayoutManager(this)
		}

		presenter.loadItems(this, false)
	}

	override fun update(items: ArrayList<imageItem>, isClear: Boolean) {
		imageAdapter?.apply {
			if (isClear) {
				imageList?.clear()
			}
			imageList = items
		}
	}

	override fun notifyAdapter() {
		imageAdapter?.notifyDataSetChanged()
	}

}
