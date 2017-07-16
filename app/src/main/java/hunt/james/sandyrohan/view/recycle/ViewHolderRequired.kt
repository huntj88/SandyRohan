package hunt.james.sandyrohan.view.recycle

import hunt.james.sandyrohan.view.pages.util.PageRequired


/**
 * Created by James on 7/16/2017.
 */
interface ViewHolderRequired {

    fun bindData(viewHolderData: ViewHolderData, callBack: PageRequired.CallBack)
}