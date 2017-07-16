package hunt.james.sandyrohan.view.pages

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.SearchPageModel
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall
import hunt.james.sandyrohan.data.di.scope.page.DaggerPageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelComponent
import hunt.james.sandyrohan.data.di.scope.page.PageModelModule
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired
import hunt.james.sandyrohan.view.recycle.GeneralAdapter
import hunt.james.sandyrohan.view.recycle.ViewHolderData
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.page_search.view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by James on 7/16/2017.
 */

class SearchPage : PageRequired, PageRequired.CallBack {

    override lateinit var mViewGroup: ViewGroup
    override lateinit var mAdapter: PageRequired.Adapter
    override var mPageID: PageID = PageID.SEARCH
    override var layoutBound: Boolean = false

    @Inject
    lateinit var mSearchPageModel: SearchPageModel

    var generalAdapter: GeneralAdapter = GeneralAdapter(this)


    override fun bindLayout(context: Context, adapter: PageRequired.Adapter) {
        this.mAdapter = adapter
        val layout = LayoutInflater.from(context).inflate(R.layout.page_search, null, false)

        val recycle: RecyclerView = layout.search_results
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycle.layoutManager = layoutManager
        recycle.adapter  = generalAdapter



        RxTextView.textChanges(layout.search_field)
                .debounce(400, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({ value -> mSearchPageModel.search(value.toString()) })


        mViewGroup = layout as ViewGroup

        val pageModelComponent: PageModelComponent = DaggerPageModelComponent
                .builder()
                .appComponent(SandyRohanApplication.di.component)
                .pageModelModule(PageModelModule())
                .build()

        pageModelComponent.inject(this)

        mSearchPageModel.bindModelToView(this)

    }

    override fun bindDataFinished() {
        Log.d("size", mSearchPageModel.mResults.size.toString())

        generalAdapter.addData(mSearchPageModel.mResults,0)
        //val textView: TextView = mViewGroup.findViewById<TextView>(R.id.item_name)
        //textView.text = mItemPageModel.itemName
    }

    override fun handleCallBack(viewHolderData: ViewHolderData) {
        mSearchPageModel.selectedItem = viewHolderData as ItemSmall
        mAdapter.addPage(PageID.ITEM)
    }
}