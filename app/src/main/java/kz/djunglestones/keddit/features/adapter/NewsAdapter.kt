package kz.djunglestones.keddit.features.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kz.djunglestones.keddit.commons.extensions.RedditNewsItem
import kz.djunglestones.keddit.commons.extensions.adapter.AdapterConstants
import kz.djunglestones.keddit.commons.extensions.adapter.ViewType
import kz.djunglestones.keddit.commons.extensions.adapter.ViewTypeDelegateAdapter
import java.util.*


class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {


    private var items : ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType{
        override fun getViewType(): Int = AdapterConstants.LOADING
    }

    init {

        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        items = ArrayList();
        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addNews(news:List<RedditNewsItem>){
        // first remove loading and notify
        val initPosition = items.size-1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition,items.size+1)

    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getNews(): List<RedditNewsItem>{
        return items
            .filter { it.getViewType() == AdapterConstants.NEWS }
            .map { it as RedditNewsItem}
    }

    private fun getLastPosition() = if (items.lastIndex ==-1) 0 else items.lastIndex


}