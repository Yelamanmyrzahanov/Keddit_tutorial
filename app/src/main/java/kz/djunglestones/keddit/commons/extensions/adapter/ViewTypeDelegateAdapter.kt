package kz.djunglestones.keddit.commons.extensions.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewParent

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder,item: ViewType)
}