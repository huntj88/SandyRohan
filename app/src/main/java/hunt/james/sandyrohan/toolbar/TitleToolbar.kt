package hunt.james.sandyrohan.toolbar

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by James on 7/9/2017.
 */
class TitleToolbar(title: String): ToolbarRequired {
    override lateinit var mViewGroup: ViewGroup
    var mTitle: String = title

    override fun bindLayout(context: Context) {
        mViewGroup = LinearLayout(context)

        val titleView: TextView = TextView(context)
        titleView.text = mTitle
        mViewGroup.addView(titleView)
    }
}