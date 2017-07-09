package hunt.james.sandyrohan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import hunt.james.sandyrohan.pages.util.PageManager
import hunt.james.sandyrohan.pages.util.SwipeOptionalViewPager
import hunt.james.sandyrohan.toolbar.ToolbarManager
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : AppCompatActivity() {

    lateinit var viewPager: SwipeOptionalViewPager
    lateinit var pageManager: PageManager
    lateinit var toolbarManager: ToolbarManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        setSupportActionBar(toolbar)

        viewPager = single_view_pager
        toolbarManager = ToolbarManager(toolbar)
        pageManager = PageManager(viewPager, toolbarManager)
    }

    override fun onBackPressed() {
        if(!pageManager.backPressed()) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        pageManager.onDestroy()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.menu_scrolling, menu)
        //return true
        toolbar.menu.clear()
        return toolbarManager.shouldUpdateMenu(menu)
    }


}
