package hunt.james.sandyrohan.toolbar

import android.content.Context
import android.view.ViewGroup

/**
 * Created by James on 7/9/2017.
 */
interface ToolbarRequired {
    var mViewGroup: ViewGroup
    fun bindLayout(context: Context)
}