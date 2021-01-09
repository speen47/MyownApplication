package com.example.myownapplication.presentation.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myownapplication.R
import com.example.myownapplication.domain.models.Actor
import com.example.myownapplication.domain.models.Movie
import com.example.myownapplication.presentation.ViewModelFactory


class FragmentMoviesDetails() : Fragment() {


    var title: TextView? = null
    var banner: ImageView? = null
    var minimumAge: TextView? = null
    var genre: TextView? = null
    var rating: RatingBar? = null
    var overview: TextView? = null

    private val viewModel: MovieDetailsViewModel by viewModels { ViewModelFactory() }
    private lateinit var adapter: ActorsAdapter
    private var recycler: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)

        findViews(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movie = arguments?.getSerializable(KEY) as Movie

        adapter = ActorsAdapter()
        // var actors = ActorsDataSource().getActors()
        recycler = view.findViewById(R.id.rv_actors)
        recycler?.adapter = adapter
        recycler?.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)


        viewModel.openMoviesLiveData.observe(this.viewLifecycleOwner, { (it?.let { setContentViews(it, view) }) })
        viewModel.openActorsLiveData.observe(this.viewLifecycleOwner, { it.let { upDateList(it) } })

        viewModel.getMovieDetails(movie.id)
        viewModel.getActors(movie.id)
    }


    private fun findViews(view: View) {
        title = view.findViewById(R.id.tv_title)
        banner = view.findViewById(R.id.banner)
        minimumAge = view.findViewById(R.id.minimum_age)
        genre = view.findViewById(R.id.genre)
        rating = view.findViewById(R.id.rating_bar)
        overview = view.findViewById(R.id.storyline_text)
    }

    private fun setContentViews(movie: Movie, view: View) {
        title?.text = movie.title
        minimumAge?.text = movie.minimumAge.toString() + "+"
        genre?.text = movie.genres.map { it.name }.joinToString(separator = ", ")
        rating?.rating = movie.ratings / 2
        overview?.text = movie.overview
        Glide.with(view.context)
                .load(movie.backdrop)
                .apply(RequestOptions().fitCenter())
                .into(banner)

    }


    private fun upDateList(actors: List<Actor>) {
        adapter.upDateList(actors)
    }

    companion object {
        fun newInstance(movie: Movie): FragmentMoviesDetails {
            val bundle = Bundle()
            bundle.putSerializable(KEY, movie)
            return FragmentMoviesDetails().apply {
                arguments = bundle
            }
        }

        const val KEY = "key"
    }


}

