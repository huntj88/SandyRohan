package hunt.james.sandyrohan.view

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.view.pages.util.PageManager
import hunt.james.sandyrohan.view.pages.util.SwipeOptionalViewPager
import kotlinx.android.synthetic.main.activity_single.*
import com.tbruyelle.rxpermissions2.RxPermissions
import io.realm.Realm


class SingleActivity : AppCompatActivity() {

    lateinit var viewPager: SwipeOptionalViewPager
    lateinit var pageManager: PageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        viewPager = single_view_pager

        val rxPermissions = RxPermissions(this)

        rxPermissions.request(Manifest.permission.INTERNET).subscribe { granted ->

            if (granted) {
                pageManager = PageManager(viewPager, toolbar_layout)
            } else {
                Log.d("granted","false")
            }

        }
    }

    override fun onBackPressed() {
        if (!pageManager.backPressed()) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        pageManager.onDestroy()
    }


}
