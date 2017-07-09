package hunt.james.sandyrohan.pages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import hunt.james.sandyrohan.pages.util.PageRequired
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.pages.util.PageID
import kotlinx.android.synthetic.main.page_test.view.*

/**
 * Created by James on 7/8/2017.
 */
class TestPage : PageRequired {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.TEST


    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_test, null, false)


        RxView.clicks(layout.button).subscribe({adapter.addPage(PageID.OTHER)})

        mViewGroup = layout as ViewGroup
    }

}