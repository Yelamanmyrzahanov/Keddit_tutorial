package kz.djunglestones.keddit.features.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kz.djunglestones.keddit.R
import kz.djunglestones.keddit.commons.extensions.adapter.ViewType
import kz.djunglestones.keddit.commons.extensions.adapter.ViewTypeDelegateAdapter
import kz.djunglestones.keddit.commons.extensions.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)) {
    }
}