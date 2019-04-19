package kz.djunglestones.keddit.commons.extensions

import kz.djunglestones.keddit.commons.extensions.adapter.AdapterConstants
import kz.djunglestones.keddit.commons.extensions.adapter.ViewType

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}