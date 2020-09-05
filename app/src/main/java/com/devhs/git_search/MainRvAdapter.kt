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


class MainRvAdapter(val context: Context, val itemList: ArrayList<GitItemData>)
    : RecyclerView.Adapter<MainRvAdapter.Holder>(){
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val repoTitle = itemView?.findViewById<TextView>(R.id.item_title)
        val repoDescriptn = itemView?.findViewById<TextView>(R.id.item_description)
        val repoProfileImg = itemView?.findViewById<ImageView>(R.id.item_profileImg)

        fun bind (item: GitItemData, context: Context) {
            repoTitle?.text = item.title
            repoDescriptn?.text = item.descripton
            if (repoProfileImg != null) {
                Glide.with(context).load(Uri.parse(item.profileImgUrl)).into(repoProfileImg)
            };
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}