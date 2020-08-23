package com.laam.movies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laam.data.database.entity.Movie
import com.laam.movies.databinding.ItemMoviesBinding

/**
 * Created by luthfiarifin on 8/23/2020.
 */
class MovieListAdapter(
    private val onItemClickListener: OnItemClickListener
) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    inner class MovieViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.data = getItem(position)
        holder.binding.root.setOnClickListener {
            onItemClickListener.onItemClicked(getItem(position))
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(movie: Movie)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }
}