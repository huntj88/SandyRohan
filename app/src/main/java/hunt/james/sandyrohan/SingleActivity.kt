package hunt.james.sandyrohan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hunt.james.sandyrohan.pages.util.PageManager
import hunt.james.sandyrohan.pages.util.SwipeOptionalViewPager
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : AppCompatActivity() {

    lateinit var viewPager: SwipeOptionalViewPager
    lateinit var pageManager: PageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        viewPager = single_view_pager
        pageManager = PageManager(viewPager)
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


}
