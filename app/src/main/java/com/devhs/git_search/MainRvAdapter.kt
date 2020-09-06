package com.devhs.git_search

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MainRvAdapter(private val context: Context, private val itemList: ArrayList<GitItemData>, private val onItemClick: (GitItemData) -> Unit)
    : RecyclerView.Adapter<MainRvAdapter.Holder>(){

    inner class Holder(itemView: View?, val onItemClick: (GitItemData) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
        private val repoTitle = itemView?.findViewById<TextView>(R.id.item_title)
        private val repoLanguage = itemView?.findViewById<TextView>(R.id.item_language)
        private val repoAvatarUrl = itemView?.findViewById<ImageView>(R.id.item_avatar_url)

        fun bind (item: GitItemData, context: Context) {
            repoTitle?.text = item.title
            repoLanguage?.text = item.language
            if (repoAvatarUrl != null) {
                Glide.with(context).load(Uri.parse(item.repoAvatarUrl)).into(repoAvatarUrl)
            }
            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return Holder(view, onItemClick)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}