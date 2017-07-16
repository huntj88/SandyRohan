package hunt.james.sandyrohan.view.pages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.jakewharton.rxbinding2.view.RxView
import hunt.james.sandyrohan.view.pages.util.PageRequired
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.TestPageModel
import hunt.james.sandyrohan.data.di.scope.page.DaggerPageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelModule
import hunt.james.sandyrohan.view.pages.util.PageID
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.page_test.view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by James on 7/8/2017.
 */
class TestPage : PageRequired {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.TEST
    override var layoutBound: Boolean = false

    @Inject
    lateinit var mTestPageModel: TestPageModel

    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_test, null, false)

        RxView.clicks(layout.page_item)
                .throttleFirst(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({adapter.addPage(PageID.ITEM)})

        RxView.clicks(layout.button)
                .throttleFirst(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({adapter.addPage(PageID.SEARCH)})

        mViewGroup = layout as ViewGroup


        val pageModelComponent: PageModelComponent = DaggerPageModelComponent
                .builder()
                .appComponent(SandyRohanApplication.di.component)
                .pageModelModule(PageModelModule())
                .build()

        pageModelComponent.inject(this)

        mTestPageModel.bindModelToView(this)

    }

    override fun bindDataFinished() {

        mViewGroup.findViewById<Button>(R.id.page_item).text = mTestPageModel.itemName
    }
}