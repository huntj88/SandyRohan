package hunt.james.sandyrohan.toolbar

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.SingleActivity
import hunt.james.sandyrohan.pages.util.PageID
import kotlinx.android.synthetic.main.activity_single.view.*

/**
 * Created by James on 7/9/2017.
 */
class ToolbarManager(toolbar: Toolbar): ToolbarController {

    var mToolbar: Toolbar = toolbar
    lateinit var visiblePageID: PageID
    //lateinit var menu: Menu

    override fun buildToolbarForPage(pageID: PageID) {
        visiblePageID = pageID

        mToolbar.inner_toolbar.removeAllViews()
        val toolbarRequired: ToolbarRequired = pageID.buildToolbar()
        toolbarRequired.bindLayout(mToolbar.context)
        mToolbar.inner_toolbar.addView(toolbarRequired.mViewGroup)
        (mToolbar.context as SingleActivity).invalidateOptionsMenu()

        //(mToolbar.context as AppCompatActivity).invalidateOptionsMenu()

    }

    fun shouldUpdateMenu(menu: Menu?): Boolean {
        if(menu!=null) {

            if (visiblePageID.hasMenu)
                (mToolbar.context as AppCompatActivity).menuInflater.inflate(visiblePageID.menu, menu)

            return visiblePageID.hasMenu
        }

        return false
    }

}