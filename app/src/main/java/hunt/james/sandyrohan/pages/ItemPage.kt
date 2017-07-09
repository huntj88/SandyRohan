package hunt.james.sandyrohan.pages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.pages.util.PageID
import hunt.james.sandyrohan.pages.util.PageRequired
import kotlinx.android.synthetic.main.page_test.view.*

/**
 * Created by James on 7/8/2017.
 */
class ItemPage: PageRequired {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.ITEM


    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_item, null, false)
        mViewGroup = layout as ViewGroup
    }
}