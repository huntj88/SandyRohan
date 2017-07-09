package hunt.james.sandyrohan.pages

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.pages.util.PageID
import hunt.james.sandyrohan.pages.util.PageRequired

/**
 * Created by James on 7/8/2017.
 */
class OtherPage: PageRequired {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.OTHER

    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {

        val linearLayout: LinearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL

        val text: TextView = TextView(context)
        text.text = "hello"
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,30f)
        text.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
        linearLayout.addView(text)

        mViewGroup = linearLayout
    }


}