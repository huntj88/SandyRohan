package hunt.james.sandyrohan.view.pages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.page.DaggerPageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelModule
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired
import javax.inject.Inject

/**
 * Created by James on 7/8/2017.
 */
class ItemPage: PageRequired {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.ITEM

    @Inject
    lateinit var itemPageModel: ItemPageModel


    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_item, null, false)

        val pageModelComponent: PageModelComponent = DaggerPageModelComponent
                .builder()
                .appComponent((context.applicationContext as SandyRohanApplication).component)
                .pageModelModule(PageModelModule())
                .build()


        pageModelComponent.inject(this)

        mViewGroup = layout as ViewGroup

    }
}