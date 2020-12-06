package com.example.myownapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMovieList : Fragment() {

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
                .add(R.id.main_container, FragmentMoviesDetails())
                .addToBackStack(null)
                .commit()
        }
        var movies = MoviesDataSource().getMovies()
        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = adapter
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter.updateList(movies)
    }


}

