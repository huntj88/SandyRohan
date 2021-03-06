package hunt.james.sandyrohan.view.pages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.di.scope.page.DaggerPageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelModule
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired
import kotlinx.android.synthetic.main.page_item_header.view.*
import javax.inject.Inject

/**
 * Created by James on 7/8/2017.
 */
class ItemPage: PageRequired, PageRequired.PrelimData {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.ITEM
    override var layoutBound: Boolean = false

    @Inject
    lateinit var mItemPageModel: ItemPageModel


    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_item, null, false)

        val pageModelComponent: PageModelComponent = DaggerPageModelComponent
                .builder()
                .appComponent(SandyRohanApplication.di.component)
                .pageModelModule(PageModelModule())
                .build()

        mViewGroup = layout as ViewGroup

        pageModelComponent.inject(this)

        mItemPageModel.bindModelToView(this)

    }

    override fun preDataFinishedBinding() {
        mViewGroup.item_name.text = mItemPageModel.itemName
    }

    override fun bindDataFinished() {
        mViewGroup.item_name.text = mItemPageModel.itemName
    }
}