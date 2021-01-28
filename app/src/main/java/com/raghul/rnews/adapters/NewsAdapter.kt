package com.raghul.rnews.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raghul.rnews.R
import com.raghul.rnews.models.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

inner class ArticleViewHolder(view:View):RecyclerView.ViewHolder(view)


    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return  ArticleViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article_preview,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                    .load(item.urlToImage)
                    .into(ivArticleImage)

            tvSource.text=item.source.name
            tvDescription.text=item.description
            tvPublishedAt.text=item.publishedAt
            tvTitle.text=item.title

            setOnItemClickListener {
                onItemClickListener?.let { it(item) }
            }

        }
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }


    private var onItemClickListener:((Article)-> Unit)?=null

    fun setOnItemClickListener(listener: (Article)->Unit){
        onItemClickListener=listener

    }
}

