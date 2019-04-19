package kz.djunglestones.keddit.features.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*
import kz.djunglestones.keddit.R
import kz.djunglestones.keddit.commons.extensions.RedditNewsItem
import kz.djunglestones.keddit.commons.extensions.adapter.ViewType
import kz.djunglestones.keddit.commons.extensions.adapter.ViewTypeDelegateAdapter
import kz.djunglestones.keddit.commons.extensions.extensions.getFriendlyTime
import kz.djunglestones.keddit.commons.extensions.extensions.inflate
import kz.djunglestones.keddit.commons.extensions.extensions.loadImg

class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}