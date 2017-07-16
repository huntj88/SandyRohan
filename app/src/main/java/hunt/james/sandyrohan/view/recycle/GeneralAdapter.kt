package hunt.james.sandyrohan.view.recycle

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import hunt.james.sandyrohan.view.pages.util.PageRequired

/**
 * Created by James on 7/16/2017.
 */
class GeneralAdapter(callback: PageRequired.CallBack): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mCallBack: PageRequired.CallBack = callback
    var cells: MutableList<ViewHolderData> = ArrayList()

    fun addData(data: List<ViewHolderData>, offset: Int)  //used to add data but retain the top cells. offset is how many top cells retained
    {
        val oldLength = itemCount
        for (i in offset..oldLength - 1) {
            this.cells.removeAt(offset)
        }
        notifyItemRangeRemoved(offset, oldLength)


        for (i in offset..data.size - 1) {
            cells.add(data[i])
        }

        notifyItemRangeInserted(offset, itemCount)
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val enum = ViewHolderEnum.fromInt(viewType)
        return enum!!.makeView(parent!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder: ViewHolderRequired = holder as ViewHolderRequired
        viewHolder.bindData(cells[position],mCallBack)
    }

    override fun getItemViewType(position: Int): Int {
        return cells[position].type.viewHolderID
    }

    override fun getItemCount(): Int {
        return cells.size
    }
}