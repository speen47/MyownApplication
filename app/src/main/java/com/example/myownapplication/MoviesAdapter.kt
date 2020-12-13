package com.example.myownapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myownapplication.data.Movie

class MoviesAdapter(private val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolder>() {


    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.onBind(movies[position], clickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateList(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val backgroundImage: ImageView = itemView.findViewById(R.id.img_movie)
    private val ageLimitation: TextView = itemView.findViewById(R.id.tv_age)
    private val genre: TextView = itemView.findViewById(R.id.tv_genre)
    private val countOfStarsOnRatingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    private val countOfReviews: TextView = itemView.findViewById(R.id.tv_reviews)
    private val title: TextView = itemView.findViewById(R.id.tv_title)
    private val duration: TextView = itemView.findViewById(R.id.tv_duration)

    fun onBind(movie: Movie, clickListener: (Movie) -> Unit) {
        itemView.setOnClickListener { clickListener(movie) }
        Glide.with(itemView.context)
            .load(movie.poster)
            .into(backgroundImage)
        ageLimitation.text = movie.minimumAge.toString() + "+"
        genre.text = movie.genres.map { it.name }.joinToString(separator = ", ")
        countOfStarsOnRatingBar.rating = movie.ratings / 2
        title.text = movie.title
        duration.text = movie.runtime.toString() + " min"

    }
}
