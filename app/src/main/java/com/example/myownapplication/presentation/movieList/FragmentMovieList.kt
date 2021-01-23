package com.example.myownapplication.presentation.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myownapplication.R
import com.example.myownapplication.domain.models.Movie
import com.example.myownapplication.presentation.ViewModelFactory
import com.example.myownapplication.presentation.movieDetails.FragmentMoviesDetails

class FragmentMovieList : Fragment() {

    private val viewModel: MovieListViewModel by viewModels { ViewModelFactory(context = requireContext().applicationContext) }

//    val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
//        Log.d("Mylog", "exception handled: ${throwable.message}")
//    }
//    val coroutineContext = SupervisorJob() + Dispatchers.Default + handlerException
//    val coroutineScope = CoroutineScope(coroutineContext)

    private lateinit var adapter: MoviesAdapter

    private var recycler: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MoviesAdapter {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesDetails.newInstance(it.id))
                    .addToBackStack(null)
                    .commit()
        }

        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = adapter
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.openMoviesLiveData.observe(this.viewLifecycleOwner, { upDateList(it) })

        viewModel.getMovies()
    }

    private fun upDateList(movies: List<Movie>) {
        adapter.updateList(movies)
    }


}

